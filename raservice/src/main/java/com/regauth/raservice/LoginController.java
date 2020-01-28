package com.regauth.raservice;

import com.regauth.data.User;
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
public class LoginController
{

    @RequestMapping(path = "/authenticate", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<User> authenticate(
            @RequestParam(name = "uerName") String userName,
            @RequestParam(name = "password") String password)
    {

        User currentUser = UserFacade.authenticate(userName, password);
        if (currentUser != null)
        {
            return new ResponseEntity<User>(currentUser, HttpStatus.OK);
        }

        User user = new User();
        user.setUserName("fail");
        return new ResponseEntity<User>(user, HttpStatus.CONFLICT);
    }
}
