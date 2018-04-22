package com.look.monkey.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.look.monkey.service.UsersService;
import com.look.monkey.service.impl.UsersServiceImpl;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
//      .antMatchers("/**").permitAll()//暂时放开一切请求
//      .antMatchers("/error").permitAll()   .logoutRequestMatcher(new AntPathRequestMatcher("logout", "GET"))
        http
        .authorizeRequests()
         .anyRequest().authenticated()
         .antMatchers("/", "/index").permitAll()
        .and()
        .formLogin()
        .loginPage("/login")
        .defaultSuccessUrl("/admin")
        .failureUrl("/login?error")
        .permitAll()
        .and()
        .logout()
        .permitAll()
        .and().csrf().disable()//默认 csrf是开启的 这样会引发logout 失败   https://docs.spring.io/spring-security/site/docs/current/reference/html/csrf.html
        ;
    }

    @Override
    public void configure(final WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/vendor/**");
        web.ignoring().antMatchers("/css/**");
        web.ignoring().antMatchers("/js/**");
        web.ignoring().antMatchers("/img/**");
        web.ignoring().antMatchers("/webjars/**");
    }

    @Bean
    public UsersService userService() {
        return new UsersServiceImpl();
    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(final AuthenticationManagerBuilder auth)
            throws Exception {
        auth.userDetailsService(userService()).passwordEncoder(passwordEncoder());
    }

    @Override
    public UserDetailsService userDetailsServiceBean() throws Exception {
        return userService();
    }

}
