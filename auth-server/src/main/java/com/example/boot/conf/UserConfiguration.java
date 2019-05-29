package com.example.boot.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class UserConfiguration extends GlobalAuthenticationConfigurerAdapter {
	
	PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
	
	public void init(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("Sachith")
			.password(passwordEncoder.encode("sachith"))
			.roles("ADMIN","USER")
			.authorities("CAN_CREATE","CAN_READ")
		.and()
			.withUser("Malith")
			.password(passwordEncoder.encode("malith"))
			.roles("USER")
			.authorities("CAN_CREATE");
	}
}
