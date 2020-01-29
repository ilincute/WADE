package coreapi.coreapi;

import coreapi.coreapi.dao.TokenDAO;
import coreapi.coreapi.services.TokenService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/core")
public class LoginController
{

    @CrossOrigin(origins = "*")
    @RequestMapping(path = "/authenticate", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<String> login(
            @RequestParam(name = "userName") String userName,
            @RequestParam(name = "password") String password)
    {
        String token = TokenService.getTokenForUser(userName, password);
        if (token != null)
        {
            return new ResponseEntity<String>(token, HttpStatus.OK);
        }

        return new ResponseEntity<>("", HttpStatus.CONFLICT);
    }

}
