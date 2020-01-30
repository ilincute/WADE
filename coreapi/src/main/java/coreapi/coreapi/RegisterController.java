package coreapi.coreapi;

import coreapi.coreapi.data.RegisterResponse;
import coreapi.coreapi.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/core")
public class RegisterController
{

    @CrossOrigin(origins = "*")
    @RequestMapping(path = "/register", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<RegisterResponse> register(
            @RequestParam(name =  "userName") String userName,
            @RequestParam(name = "lastName") String lastName,
            @RequestParam(name = "email") String email,
            @RequestParam(name = "password") String password)
    {
        RegisterResponse rr = UserService.registerUser(userName, lastName, email, password);

        if (rr.getStatus().equals("invalid"))
        {
            return new ResponseEntity<>(RegisterResponse.getInvalid(), HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(rr, HttpStatus.OK);

    }

}
