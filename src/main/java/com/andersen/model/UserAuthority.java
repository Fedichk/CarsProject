package com.andersen.model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

@Data
public class UserAuthority implements GrantedAuthority {

    private User user;

    private String authority;

}
