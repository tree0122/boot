package com.tree.boot.security.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;

import java.io.Serializable;

@Slf4j
public class CustomPermissionEvaluator implements PermissionEvaluator{
    @Override
    public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
        log.info("======== has permission ======");

        return authentication.getAuthorities()
                .stream()
                .anyMatch(a -> a.getAuthority().equals(permission));
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object permission) {
        return false;
    }
}
