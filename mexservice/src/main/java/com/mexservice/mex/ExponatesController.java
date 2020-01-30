package com.mexservice.mex;


import com.mexservice.mex.data.Exponate;
import com.mexservice.mex.services.ExponateService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/mex")
public class ExponatesController
{
    @CrossOrigin(origins = "*")
    @RequestMapping(path = "/getAll", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<List<Exponate>> getAllExponates()
    {
        List<Exponate> exponates = ExponateService.getAll();
        if (exponates != null)
        {
            return new ResponseEntity<>(exponates, HttpStatus.OK);
        }

        return new ResponseEntity<>(exponates, HttpStatus.CONFLICT);
    }
}
