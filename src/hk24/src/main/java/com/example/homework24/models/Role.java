package com.example.homework24.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {
    ADMIN(Roles.ADMIN),
    USER(Roles.USER),
    STAFF(Roles.STAFF);

    private final String role;

    public static class Roles {
        public static final String ADMIN = "admin";
        public static final String USER = "user";
        public static final String STAFF = "staff";
    }
}


