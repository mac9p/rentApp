package com.mac9p.rentapp.Auth;

import com.google.common.collect.Lists;
import com.mac9p.rentapp.Security.EntityRole;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Component
public class ApplicationUserDaoImpl implements ApplicationUserDao {

    private final PasswordEncoder passwordEncoder;

    public ApplicationUserDaoImpl(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<ApplicationUserDetails> selectApplicationUserByUsername(String username) {
        return Optional.empty();
    }

    /*private List<ApplicationUserDetails> getApplicationUsers(){
        *//*List<ApplicationUserDetails> applicationUsers = Lists.newArrayList(
                new ApplicationUserDetails("jankowalski",
                        passwordEncoder.encode("123")
                        //.roles(EntityRole.USER.name())
                        ,EntityRole.USER.getGrantedAuthorities()
                        );*//*



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
        )*/
    }
