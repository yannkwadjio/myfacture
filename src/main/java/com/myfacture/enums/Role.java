package com.myfacture.enums;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Role {
    ADMIN("Administrateur"),
    USER("Opérateur"),
    CUSTOMER("Client");

    private final String roleName;
}
