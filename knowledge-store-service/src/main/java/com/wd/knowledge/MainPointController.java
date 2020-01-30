package com.wd.knowledge;

import com.wd.knowledge.aggregators.DBPediaAggregator;
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

    @RequestMapping(path = "/exponate", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getExponateData(@RequestParam(name="exponateName") String exponateName) {

        String wiki = DBPediaAggregator.queryMueumExponates(exponateName);

        if (wiki.equals(""))
        {
            return new ResponseEntity<>(wiki, HttpStatus.CONFLICT);
        }

        return new ResponseEntity<>(wiki, HttpStatus.OK);
    }
}
