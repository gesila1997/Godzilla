package com.evan.indusfoserver.service;

import com.evan.indusfoserver.mapper.PdamageMapper;
import com.evan.indusfoserver.pojo.Pdamage;
import com.evan.indusfoserver.pojo.Pmonthsum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class PdamageService {
    @Autowired
    private PdamageMapper pdamageMapper;

    @GetMapping(value = "/api/Pdaselect")
    public List<Pdamage> Pdaselect() throws Exception {
        return pdamageMapper.Pdaselect();
    }

}
