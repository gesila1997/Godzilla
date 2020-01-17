package com.evan.indusfoserver.service;

import com.evan.indusfoserver.mapper.ClientMapper;
import com.evan.indusfoserver.pojo.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientMapper clientMapper;

    @GetMapping(value = "/api/PClselect")
    public List<Client> PClselect() throws Exception{

        return clientMapper.PClselect();
    }

}
