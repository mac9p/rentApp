package com.mac9p.rentapp.Security;

import com.google.common.collect.Sets;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static com.mac9p.rentapp.Security.EntityPermission.*;

public enum EntityRole {
    USER(Sets.newHashSet(USER_READ,USER_WRITE)),
    ADMIN(Sets.newHashSet(DISC_READ,DISC_WRITE,USER_READ,USER_WRITE)),
    ADMIN_TRAINEE(Sets.newHashSet(DISC_READ,USER_READ));


    @Getter
    private final Set<EntityPermission> permissions;

    EntityRole(Set<EntityPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<SimpleGrantedAuthority> getGrantedAuthorities(){
       Set<SimpleGrantedAuthority> permissions = getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
        permissions.add(new SimpleGrantedAuthority("ROLE_"+this.name()));
        return permissions;
    }
}
