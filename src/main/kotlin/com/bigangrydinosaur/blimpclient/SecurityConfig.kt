package com.bigangrydinosaur.blimpclient

import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.web.servlet.invoke

@Configuration
class SecurityConfig: WebSecurityConfigurerAdapter() {

    override fun configure(http: HttpSecurity?) {
        if (http == null) return
        http.csrf().disable().antMatcher("/**")
                .authorizeRequests()
                .antMatchers("/**", "/login**", "/api/url")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .cors()
                .and()
                .oauth2Login()
    }
}