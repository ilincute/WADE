package coreapi.coreapi;

import coreapi.coreapi.data.Exponate;
import coreapi.coreapi.services.ExponateService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/core")
public class ExponatesController
{
    @CrossOrigin(origins = "*")
    @RequestMapping(path = "/allExponates", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<List<Exponate>> getExponates()
    {
        try {
            List<Exponate> exponates = ExponateService.getAll();
            return new ResponseEntity<>(exponates, HttpStatus.OK);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(ExponateService.getEmptyResponse(), HttpStatus.OK);
    }

}
