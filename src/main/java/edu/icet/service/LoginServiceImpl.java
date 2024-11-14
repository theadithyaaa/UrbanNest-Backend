package edu.icet.service;

import edu.icet.dto.Login;
import edu.icet.entity.LoginEntity;
import edu.icet.repository.LoginRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService{

    private final LoginRepository repository;
    private final ModelMapper mapper;
    @Override
    public List<Login> getAll() {
        List<Login> loginArrayList = new ArrayList<>();
        repository.findAll().forEach(entity->{
            loginArrayList.add(mapper.map(entity, Login.class));
        });
        return loginArrayList;
    }

    @Override
    public void addLogin(Login login) {
        repository.save(mapper.map(login, LoginEntity.class));
    }


}
