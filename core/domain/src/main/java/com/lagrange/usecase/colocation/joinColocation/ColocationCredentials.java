package com.lagrange.usecase.colocation.joinColocation;

public class ColocationCredentials {
    private final String tag;
    private final String password;

    public ColocationCredentials(String tag, String password) {
        this.tag = tag;
        this.password = password;
    }

    public String getTag() {
        return tag;
    }

    public String getPassword() {
        return password;
    }
}
