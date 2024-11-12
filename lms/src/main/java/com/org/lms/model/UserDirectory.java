package com.org.lms.model;

import lombok.Getter;

import java.util.concurrent.ConcurrentHashMap;

public class UserDirectory {
    String userName;
    char[] pwd;

    @Getter
    private ConcurrentHashMap<String, User> users = new ConcurrentHashMap<>();
}
