package coreapi.coreapi;

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
public class TokenController
{
    public static final String VALID = "valid";
    public static final String INVALID = "invalid";

    @RequestMapping(path = "/check", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<String> checkValidToken(@RequestParam(name = "token") String token)
    {
        if (TokenService.check(token))
        {
            return new ResponseEntity<>(VALID, HttpStatus.OK);
        }

        return new ResponseEntity<>(INVALID, HttpStatus.CONFLICT);
    }

}
