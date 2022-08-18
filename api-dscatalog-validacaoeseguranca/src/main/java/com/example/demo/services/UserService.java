package com.example.demo.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.RoleDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.dto.UserInsertDTO;
import com.example.demo.entities.Role;
import com.example.demo.entities.User;
import com.example.demo.exceptions.ApiException;
import com.example.demo.repositories.RoleRepository;
import com.example.demo.repositories.UserRepository;

@Service
public class UserService implements UserDetailsService{
	
	private static Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserRepository repository;

	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	
	@Transactional(readOnly = true)
	public Page<UserDTO> findPageable(Pageable pageable) {
		Page<User> users = repository.findAll(pageable);
		return users.map(obj -> new UserDTO(obj));
	}

	
	@Transactional(readOnly = true)
	public List<UserDTO> findAll() {
		return repository.findAll()
				.stream().map(obj -> new UserDTO(obj)).collect(Collectors.toList());
	}

	
	@Transactional(readOnly = true)
	public UserDTO findById(Long id) {
		Optional<User> userOpt = repository.findById(id);
		User user = userOpt.orElseThrow(() -> new ApiException("Entity not found"));
		return new UserDTO(user);
	}

	@Transactional
	public UserDTO save(UserInsertDTO dto) {
		verifyEmail(dto.getEmail());
		User user = new User();
		copyDtoToEntity(user, dto);
		user.setPassword(passwordEncoder.encode(dto.getPassword()));
		return new UserDTO(repository.save(user));
	}

	@Transactional
	public UserDTO update(Long id, UserInsertDTO dto) {
		Optional<User> userOpt = repository.findById(id);
		User user = userOpt.orElseThrow(() -> new ApiException("Entity not found"));
		if (!dto.getEmail().equals(user.getEmail())) {
			verifyEmail(dto.getEmail());
		}
		copyDtoToEntity(user, dto);
		user = repository.save(user);
		return new UserDTO(user);
	}

	@Transactional
	public void delete(Long id) {
		//repository.findById(id).orElseThrow(() -> new ApiException("User not found by id = " + id));
		try {
			repository.deleteById(id);
		}
		catch(EmptyResultDataAccessException e) {
			throw new ApiException("Id not found " + id);
		}
		catch(DataIntegrityViolationException e) {
			throw new ApiException("Integrity violation");
		}
		
	}
	
	private void verifyEmail(String email) {
		User user = repository.findByEmail(email);
		if (user != null) {
			throw new ApiException("User with email " + email + " already exist");
		}
	}
	
	private void copyDtoToEntity(User entity, UserDTO dto) {
		entity.setEmail(dto.getEmail());

		entity.getRoles().clear();
		for (RoleDTO roleDto : dto.getRoles()){
			Optional<Role> roleOpt = roleRepository.findById(roleDto.getId());
			if (roleOpt.isPresent()){
				entity.getRoles().add(roleOpt.get());
			}
		}
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = repository.findByEmail(username);
		if (user == null) {
			logger.error("User with email " + username + " not found");
			throw new ApiException("User with email " + username + " not found");
		}
		logger.info("User with email " + username + " found!");
		return user;
	}
	



}
