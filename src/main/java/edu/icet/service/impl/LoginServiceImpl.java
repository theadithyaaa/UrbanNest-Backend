package edu.icet.service.impl;

import edu.icet.dto.Login;
import edu.icet.dto.LoginResponse;
import edu.icet.entity.LoginEntity;
import edu.icet.repository.LoginRepository;
import edu.icet.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {

    private final LoginRepository repository;
    private final ModelMapper mapper;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public List<Login> getAll() {
        List<Login> loginArrayList = new ArrayList<>();
        repository.findAll().forEach(entity->{
            loginArrayList.add(mapper.map(entity, Login.class));
        });
        return loginArrayList;
    }

    @Override
    public LoginResponse loginUser(Login login) {
        String msg = "";
        LoginEntity loginEntity = repository.findByEmail(login.getEmail());
        if (loginEntity != null) {
            String password = login.getPassword();
            String encodedPassword = loginEntity.getPassword();
            boolean isPasswordRight = passwordEncoder.matches(password, encodedPassword);
            if (isPasswordRight) {
                Optional<LoginEntity> employee = repository.findByEmailOrPassword(login.getEmail(), encodedPassword);
                if (employee.isPresent()) {
                    return new LoginResponse("Login Success!", true);
                } else {
                    return new LoginResponse("Login Failed!", false);
                }
            } else {
                return new LoginResponse("Password does not match", false);
            }
        }else {
            return new LoginResponse("Email does not exit", false);
        }
    }

    @Override
    public String addLogin(Login login) {
//        repository.save(mapper.map(login, LoginEntity.class));
        LoginEntity loginEntity = new LoginEntity(
                login.getId(),
                login.getName(),
                login.getEmail(),
                this.passwordEncoder.encode(login.getPassword())
        );
        repository.save(loginEntity);
        return loginEntity.getName();
    }



}
