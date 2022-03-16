package com.mac9p.rentapp.Auth;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ApplicationUserService implements UserDetailsService {

    private final ApplicationUserDao applicationUserRepo;

    public ApplicationUserService(ApplicationUserDao applicationUserRepo) {
        this.applicationUserRepo = applicationUserRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return applicationUserRepo
                .selectApplicationUserByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("username not found"));
    }
}
