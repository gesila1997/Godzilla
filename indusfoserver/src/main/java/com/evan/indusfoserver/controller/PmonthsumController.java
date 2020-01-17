package com.evan.indusfoserver.controller;

import com.evan.indusfoserver.pojo.Pmonthsum;
import com.evan.indusfoserver.pojo.Psum;
import com.evan.indusfoserver.service.PmonthsumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Scope("prototype")
@CrossOrigin
public class PmonthsumController {
    @Autowired
    private PmonthsumService pmonthsumService;

    @GetMapping(value = "/api/Pmoselect")
    public List<Pmonthsum> Pmoselect() throws Exception {
        return pmonthsumService.Pmoselect();
    }

}
