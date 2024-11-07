package edu.icet.service;

import edu.icet.dto.Customer;
import edu.icet.dto.Login;

import java.util.List;

public interface LoginService {
    List<Login> getAll();
    void addlogin(Login login);

}
