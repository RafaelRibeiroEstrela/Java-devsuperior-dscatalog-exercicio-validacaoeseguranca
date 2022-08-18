package com.example.demo.components;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;

@SuppressWarnings("deprecation")
@Component
public class JwtTokenEnhancer implements TokenEnhancer{
	
	@Autowired
	private UserRepository userRepository;

	//ADICIONA ATRIBUTOS AO TOKEN
	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		User user = userRepository.findByEmail(authentication.getName());
		Map<String, Object> map = new HashMap<>();
		map.put("userId", user.getId());
		
		DefaultOAuth2AccessToken token = (DefaultOAuth2AccessToken) accessToken;
		token.setAdditionalInformation(map);
		return token;
	}

}