package com.example.edur.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import static com.example.edur.security.ApplicationUserRole.ADMIN;
import static com.example.edur.security.ApplicationUserRole.EMPLOYEE;

import java.util.concurrent.TimeUnit;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;


    @Autowired
    public ApplicationSecurityConfig(PasswordEncoder passwordEncoder){
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/","/css/*","/js/*").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                	.loginPage("/login").permitAll()
                	.defaultSuccessUrl("/leave", true)
                	.passwordParameter("password")
                	.usernameParameter("username")
                .and()
                .rememberMe()
                	.tokenValiditySeconds((int)TimeUnit.DAYS.toSeconds(21))
                	.key("securekey")
                	.rememberMeParameter("remember-me")
                .and()
                .logout()
                	.logoutUrl("/logout")
                	.logoutRequestMatcher(new AntPathRequestMatcher("/logout","GET"))
                	.clearAuthentication(true)
                	.invalidateHttpSession(true)
                	.deleteCookies("JSESSIONID", "remember-me")
                	.logoutSuccessUrl("/login");
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails ritabrata = User.builder()
                .username("ritabrata")
                .password(passwordEncoder.encode("password"))
                .authorities(EMPLOYEE.getGrantedAuthorities())
                .build();

        UserDetails ria = User.builder()
                .username("ria")
                .password(passwordEncoder.encode("password"))
                .authorities(ADMIN.getGrantedAuthorities())
                .build();


        return new InMemoryUserDetailsManager(
                ritabrata,
                ria
        );
    }
}
