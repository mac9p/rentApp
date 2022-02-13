package com.mac9p.rentapp.Security;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;

import java.util.Set;

public enum EntityPermission {
    USER_READ("user:read"),
    USER_WRITE("user:write"),
    DISC_READ("disc:read"),
    DISC_WRITE("disc:write");

    @Getter
    private final String permission;

    EntityPermission(String permission) {
        this.permission = permission;
    }

}
