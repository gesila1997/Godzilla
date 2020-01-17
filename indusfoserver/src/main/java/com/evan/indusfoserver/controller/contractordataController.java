package com.evan.indusfoserver.controller;

import com.evan.indusfoserver.pojo.Client;
import com.evan.indusfoserver.pojo.Contractordata;
import com.evan.indusfoserver.service.ContractordataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Scope("prototype")
@CrossOrigin
public class contractordataController {

    @Autowired
    private ContractordataService contractordataService;

    @GetMapping(value = "/api/Conselect")
    public List<Contractordata> Conselect() throws Exception {
        return contractordataService.Conselect();
    }


}
