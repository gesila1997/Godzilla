package com.evan.indusfoserver.controller;

import com.evan.indusfoserver.pojo.Pdamage;
import com.evan.indusfoserver.service.PdamageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Scope("prototype")
@CrossOrigin
public class PdamageController {

    @Autowired
    private PdamageService pdamageService;


    @GetMapping(value = "/api/Pdaselect")
    public List<Pdamage> Pdaselect() throws Exception {
        return pdamageService.Pdaselect();
    }

}
