package edu.icet.controller;

import edu.icet.dto.Login;
import edu.icet.service.LoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/login")
@RestController
@RequiredArgsConstructor
@CrossOrigin
@Slf4j
public class LoginController {
    @Autowired
    final LoginService service;

    @GetMapping("/get-all")
    public List<Login> getLogin(){
        return service.getAll();
    }

    @PostMapping("/add-login")
    @ResponseStatus(HttpStatus.CREATED)
    public void addLogin(@RequestBody Login login){
        log.info("updated-> {}",login);
        service.addLogin(login);
    }
}
