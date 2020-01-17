package com.evan.indusfoserver.controller;

import com.evan.indusfoserver.pojo.Psum;
import com.evan.indusfoserver.service.PsumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Scope("prototype")
@CrossOrigin
public class PsumController {
    @Autowired
    private PsumService psumService;

    @GetMapping(value = "/api/Psumselect")
    public List<Psum> Psumselect() throws Exception {
        return psumService.Psumselect();
    }

}
