package com.db.campus.property.security;

import com.db.campus.property.dto.UserAccountDto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface SecurityService {

    String findLoggedInUsername();

    void login(String login, String password);

    String encodePassword(String password);

    void logout(HttpServletRequest request, HttpServletResponse response);

    List<UserAccountDto> getAllUsers();

}
