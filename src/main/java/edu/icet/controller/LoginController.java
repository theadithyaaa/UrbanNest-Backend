package edu.icet.controller;

import edu.icet.dto.Login;
import edu.icet.dto.LoginResponse;
import edu.icet.service.LoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @PostMapping(path = "/save")
    public String saveLogin(@RequestBody Login login){
        return service.addLogin(login);
    }

//    @PostMapping(path = "/login")
//    public ResponseEntity<?> loginEmployee(@RequestBody Login login) {
//        System.out.println("Login attempt with email: " + login.getEmail());
//        LoginResponse loginResponse = service.loginUser(login);
//        return ResponseEntity.ok(loginResponse);
//    }



//    @PostMapping("/add-login")
//    @ResponseStatus(HttpStatus.CREATED)
//    public void addLogin(@RequestBody Login login){
//        log.info("updated-> {}",login);
//        service.addLogin(login);
//    }
}
