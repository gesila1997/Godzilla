package com.evan.indusfoserver.controller;


import com.evan.indusfoserver.pojo.Ptype;
import com.evan.indusfoserver.service.PtypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Scope("prototype")
@CrossOrigin
public class PtypeController {
    @Autowired
    private PtypeService ptypeService;

    @GetMapping(value = "/api/select")
    public List<Ptype> select() throws Exception {
        return ptypeService.select();
    }

}
