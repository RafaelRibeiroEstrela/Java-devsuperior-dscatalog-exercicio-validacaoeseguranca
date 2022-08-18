package com.example.demo.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Email;

import com.example.demo.entities.Role;
import com.example.demo.entities.User;

public class UserDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    
    @Email(message = "Invalid e-mail")
    private String email;

    private Set<RoleDTO> roles = new HashSet<>();

    public UserDTO(){

    }

    public UserDTO(Long id, String firstName, String lastName, String email) {
        this.id = id;
        this.email = email;
    }

    public UserDTO(User user){
        id = user.getId();
        email = user.getEmail();
        user.getRoles().forEach(obj -> this.roles.add(new RoleDTO(obj)));
    }

    public UserDTO(User entity, Set<Role> roles){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

	public Set<RoleDTO> getRoles() {
        return roles;
    }

}
