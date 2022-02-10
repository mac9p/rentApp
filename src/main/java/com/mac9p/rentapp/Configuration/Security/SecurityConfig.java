package com.mac9p.rentapp.Configuration.Security;

import com.mac9p.rentapp.Security.EntityPermission;
import com.mac9p.rentapp.Security.EntityRole;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;

    public SecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/","index","/css/*","/js/*").permitAll()
                .antMatchers("/users/*").hasRole(EntityRole.USER.name())
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService(){


        UserDetails janKowalskiUser = User.builder()
                .username("jankowalski")
                .password(passwordEncoder.encode("pass"))
                .roles(EntityRole.USER.name())
                .build();


        UserDetails karolinaUser = User.builder()
                .username("karolina")
                .password(passwordEncoder.encode("123"))
                .roles(EntityRole.ADMIN.name())
                .build();

        return new InMemoryUserDetailsManager(
                janKowalskiUser,
                karolinaUser
        );
    }
}
