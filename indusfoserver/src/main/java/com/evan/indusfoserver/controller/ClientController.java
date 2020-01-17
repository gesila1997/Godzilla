package com.evan.indusfoserver.controller;

import com.evan.indusfoserver.pojo.Client;
import com.evan.indusfoserver.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Scope("prototype")
@CrossOrigin
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping(value = "/api/PClselect")
    public List<Client> PClselect() throws Exception {
        return clientService.PClselect();
    }
}
