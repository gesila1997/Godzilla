package com.evan.indusfoserver.controller;

import com.evan.indusfoserver.pojo.ProText;
import com.evan.indusfoserver.service.ProTextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Scope("prototype")
@CrossOrigin
public class ProTextController {
    @Autowired
    private ProTextService proTextService;

    @GetMapping(value = "/api/Proselect")
    public List<ProText> Proselect() throws Exception {
        return proTextService.Proselect();
    }

}
