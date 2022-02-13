package com.mac9p.rentapp.Configuration.Security;

import com.mac9p.rentapp.Security.EntityPermission;
import com.mac9p.rentapp.Security.EntityRole;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
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
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;

    public SecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/","index","/css/*","/js/*").permitAll()
                .antMatchers("/users/*").hasRole(EntityRole.USER.name())
                /*.antMatchers("/management/**").hasRole(EntityRole.ADMIN.name())
                .antMatchers("/management/**").hasRole(EntityRole.ADMIN_TRAINEE.name())
                */
                .antMatchers(HttpMethod.DELETE,"/discs/**").hasAuthority(EntityPermission.DISC_WRITE.name())
                .antMatchers(HttpMethod.POST,"/discs/**").hasAuthority(EntityPermission.DISC_WRITE.name())
                .antMatchers(HttpMethod.PUT,"/discs/**").hasAuthority(EntityPermission.DISC_WRITE.name())
                .antMatchers(HttpMethod.GET,"/**").hasAnyRole(EntityRole.ADMIN.name(),EntityRole.ADMIN_TRAINEE.name())
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
                .password(passwordEncoder.encode("123"))
                //.roles(EntityRole.USER.name())
                .authorities(EntityRole.USER.getGrantedAuthorities())
                .build();


        UserDetails karolinaUser = User.builder()
                .username("karolina")
                .password(passwordEncoder.encode("123"))
                //.roles(EntityRole.ADMIN.name())
                .authorities(EntityRole.ADMIN.getGrantedAuthorities())
                .build();

        UserDetails tomaszUser = User.builder()
                .username("tomasz")
                .password(passwordEncoder.encode("123"))
                .authorities(EntityRole.ADMIN_TRAINEE.getGrantedAuthorities())
                //.roles(EntityRole.ADMIN_TRAINEE.name())
                .build();

        return new InMemoryUserDetailsManager(
                janKowalskiUser,
                karolinaUser,
                tomaszUser
        );
    }
}
