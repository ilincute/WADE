package coreapi.coreapi;

import coreapi.coreapi.dao.TokenDAO;
import coreapi.coreapi.services.TokenService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/core")
public class LoginController
{

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
