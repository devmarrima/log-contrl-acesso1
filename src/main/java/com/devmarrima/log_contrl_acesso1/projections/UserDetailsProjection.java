package com.devmarrima.log_contrl_acesso1.projections;

public interface UserDetailsProjection {

    String getUsername();

    String getPassword();

    Long getRoleId();

    String getAuthority();
}
