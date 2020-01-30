package coreapi.coreapi;

import coreapi.coreapi.data.RegisterResponse;
import coreapi.coreapi.services.QRService;
import coreapi.coreapi.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
@RequestMapping("/core")
public class QRController
{

    @CrossOrigin(origins = "*")
    @RequestMapping(path = "/qr", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<String> register(@RequestParam(name = "qr") String qrText)
    {
        String resp = "";
        try {
            resp = QRService.queryExponate(qrText);
            if (!resp.equals(""))
            {
                return new ResponseEntity<>(resp, HttpStatus.OK);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(resp, HttpStatus.CONFLICT);
    }
}
