package com.moon.myStory.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(final HttpSecurity http) throws Exception {

        //@formatter:off
        http.authorizeRequests()
                .antMatchers("/", "/user/modify").authenticated()
                .anyRequest().permitAll()
                .and()

                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/process-login")
                .defaultSuccessUrl("/home")
                .failureUrl("/login?error=true")
                .permitAll()
                .and()

                .logout()
                .logoutSuccessUrl("/login?logout=true")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .permitAll()
                .and()
                .csrf()
                .disable();
        //@formatter:on
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
}