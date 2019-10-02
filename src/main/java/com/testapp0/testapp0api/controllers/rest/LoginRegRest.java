package com.testapp0.testapp0api.controllers.rest;

import com.testapp0.testapp0api.controllers.ResourceNotFoundException;
import com.testapp0.testapp0api.controllers.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class LoginRegRest {

    @Autowired
    private UsersRepository usersRepository;

    @PostMapping(path = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public TUsers login(@Valid @RequestBody TUsers par) {
        String uname = par.getUname(),
        pass = par.getPass();
        return usersRepository.findByUnamePass(uname, pass)
                .orElseThrow(() -> new ResourceNotFoundException("LoginRegRest", "uname", uname));
    }

    @PostMapping(path = "/signup", produces = MediaType.APPLICATION_JSON_VALUE)
    public TUsers signup(@Valid @RequestBody TUsers par) {
        return usersRepository.save(par);
    }

}
