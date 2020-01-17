package com.evan.indusfoserver.service;

import com.evan.indusfoserver.mapper.ContractordataMapper;
import com.evan.indusfoserver.pojo.Contractordata;
import com.evan.indusfoserver.pojo.Pdamage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class ContractordataService {

    @Autowired
    private ContractordataMapper contractordataMapper;

    @GetMapping(value = "/api/Conselect")
    public List<Contractordata> Conselect() throws Exception {
        return contractordataMapper.Conselect();
    }


}
