package com.bookthief.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableGlobalMethodSecurity(prePostEnabled = true)
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.inMemoryAuthentication()
				.withUser("user").password("password").roles("USER");
	}


    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http
        .cors().and()
        .authorizeRequests()
        .antMatchers("/admin/**").authenticated()//.hasAnyRole("ADMIN","USER")
        .and().formLogin().loginPage("/login").permitAll()
        .and().logout();
    http.csrf().disable();
    http.headers().frameOptions().disable();
    }


   
}