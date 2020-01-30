package com.regauth.raservice;

import com.regauth.data.RegisterResponse;
import com.regauth.facades.UserFacade;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/ra")
public class RegistrationController
{

    @RequestMapping(path = "/register", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<RegisterResponse> register(
            @RequestParam(name = "userName") String userName,
            @RequestParam(name = "lastName") String lastName,
            @RequestParam(name = "email") String email,
            @RequestParam(name = "password") String password)
    {

        try
        {
            RegisterResponse rr = UserFacade.register(userName, lastName, email, password);
            return new ResponseEntity<>(rr, HttpStatus.CREATED);
        }
        catch (Exception e)
        { }

        return new ResponseEntity<>(RegisterResponse.getInvalid(), HttpStatus.CONFLICT);
    }
}
