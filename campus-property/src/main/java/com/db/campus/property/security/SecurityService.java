package com.db.campus.property.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface SecurityService {

    String findLoggedInUsername();

    void login(String login, String password);

    String encodePassword(String password);

    void logout(HttpServletRequest request, HttpServletResponse response);

}
