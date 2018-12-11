package com.db.campus.property.security;

public interface SecurityService {

    String findLoggedInUsername();

    void autoLogin(String login, String password);

}
