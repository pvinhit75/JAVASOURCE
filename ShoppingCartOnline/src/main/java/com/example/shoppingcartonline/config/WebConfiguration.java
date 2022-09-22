package com.example.shoppingcartonline.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class WebConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    UserDetailsImpl userDetailsService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        //Setting Service to find User in the database.
        //And Setting PasswordEncoder
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());

    }
    @Override
    pritected void configure(HttpSecurity http) throws Exception{
        http.csrf().disable();

        http.authorizeRequests().antMatchers("/admin/orderList", "/admin/order", "/admin/accountInfo")//
              .access("hasAnyRole('ROLE_EMPLOYEE', 'ROLE_MANAGER')");

        //Page only for MANAGER
        http.authorizeRequests().antMatchers("/admin/product").access("hasRole('ROLE_MANAGER')");


        //When user login, tole XX
        //But access to the page requires the YY role,
        //An AccessDeniedException wil be thrown.

        http.authorizeRequests().and().formLogin()//

                .loginProcessingUrl("/j_spring_seciruty_check") //Submit URL
                .loginPage("/admin/login")
                .defaultSuccessUrl("admin.accountInfo")
                .failureUrl("/admin/login?error=true")
                .usernameParameter("username")
                .passwordParameter("password")

                //Configuration for the Logout page.
                //(After logout, go to home page)
                .and().logout().logoutUrl("/admin/logout")
    }
    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        // Load file: validation.properties
        messageSource.setBasename("classpath:validation");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

}
