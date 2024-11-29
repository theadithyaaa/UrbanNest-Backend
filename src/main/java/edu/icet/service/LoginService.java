package edu.icet.service;

import edu.icet.dto.Login;
import edu.icet.dto.LoginResponse;

import java.util.List;

public interface LoginService {
    LoginResponse loginUser(Login login);
    String addLogin(Login login);

    List<Login> getAll();
}
