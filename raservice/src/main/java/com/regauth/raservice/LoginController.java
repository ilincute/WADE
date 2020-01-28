package com.regauth.raservice;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/ra")
public class LoginController
{
    @PostMapping("/register")
    public String tryRegister(
            @RequestParam(value = "userName") String userName,
            @RequestParam(value = "lastName") String lastName,
            @RequestParam(value = "email") String email,
            @RequestParam(value = "password") String password)
    {
        System.out.println(userName);
        System.out.println(lastName);
        System.out.println(email);
        System.out.println(password);

        return "hello";
    }

    @RequestMapping(path = "/sayHello", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> hello()
    {
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

}
