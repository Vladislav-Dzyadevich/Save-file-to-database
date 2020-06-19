package com.company.config;

import com.company.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    public void registerGlobalAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(encoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/registration")
                .permitAll()
                .antMatchers("/admin/**")
                .hasAnyRole(Role.ADMIN.name())
                .and()
                .exceptionHandling()
                .accessDeniedPage("/unauthorized")
                .and()
                .formLogin()
                .loginPage("/authorization")
                .loginProcessingUrl("/authorization")
                .failureUrl("/authorization?error")
                .usernameParameter("login")
                .passwordParameter("password")
                .successHandler((req, res, auth) -> {
                    User user = (User) SecurityContextHolder
                            .getContext()
                            .getAuthentication()
                            .getPrincipal();

                    for (GrantedAuthority authority : user.getAuthorities()) {
                        if (Role.ADMIN.toString().equals(authority.getAuthority())) {
                            res.sendRedirect("/admin/menu");
                        } else {
                            res.sendRedirect("/userPage");
                        }
                    }
                })
                .permitAll()
                .and()
                .logout()
                .permitAll()
                .logoutUrl("/logout");
    }

}
