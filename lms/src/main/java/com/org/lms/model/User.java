package com.org.lms.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
public class User {

    @EqualsAndHashCode.Include
    @Getter
    String user;

    @Getter
    String pwd;

    @Getter
    Role role;
}
