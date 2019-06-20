package com.example.enjoy.domain;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum SocialType {
    NAVER("naver"),
    GOOGLE("google");

    private final String ROLE_PREFIX = "ROLE_";
    private String name;

    public String getRoleType() {
        return ROLE_PREFIX + name.toUpperCase();
    }

    public String getValue() {
        return name;
    }

    public boolean isEquals(String authority) {
        return this.getRoleType().equals(authority);
    }
}
