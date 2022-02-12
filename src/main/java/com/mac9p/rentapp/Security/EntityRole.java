package com.mac9p.rentapp.Security;

import com.google.common.collect.Sets;

import java.util.Set;

import static com.mac9p.rentapp.Security.EntityPermission.*;

public enum EntityRole {
    USER(Sets.newHashSet(USER_READ,USER_WRITE)),
    ADMIN(Sets.newHashSet(DISC_READ,DISC_WRITE,USER_READ,USER_WRITE)),
    ADMIN_TRAINEE(Sets.newHashSet(DISC_READ,USER_READ));


    private final Set<EntityPermission> permissions;

    EntityRole(Set<EntityPermission> permissions) {
        this.permissions = permissions;
    }
}
