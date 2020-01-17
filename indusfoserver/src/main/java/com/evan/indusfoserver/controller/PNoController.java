package com.evan.indusfoserver.controller;


import com.evan.indusfoserver.pojo.PNo;
import com.evan.indusfoserver.service.PNoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Scope("prototype")
@CrossOrigin
public class PNoController {
    @Autowired
    private PNoService pNoService;

    @GetMapping(value = "/api/Pnoselect")
    public List<PNo> Pnoselect() throws Exception {

        return pNoService.Pnoselect();

    }
}
