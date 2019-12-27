package com.wd.knowledge;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/knowledge")
public class MainPointController {

    @RequestMapping(path = "/exponate", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getExponateData(
            @RequestParam(name="exponateName") String exponateName,
            @RequestParam(name="targetMuseum") String targetMuseum) {


        // perform call(s) to the aggregation service

        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
