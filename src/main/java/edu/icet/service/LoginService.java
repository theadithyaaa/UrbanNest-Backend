package edu.icet.service;

import edu.icet.dto.Login;

import java.util.List;

public interface LoginService {
    List<Login> getAll();
    void addLogin(Login login);

}
