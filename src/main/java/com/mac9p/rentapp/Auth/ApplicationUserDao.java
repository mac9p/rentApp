package com.mac9p.rentapp.Auth;

import java.util.Optional;

public interface ApplicationUserDao {

    public Optional<ApplicationUserDetails> selectApplicationUserByUsername(String username);
}
