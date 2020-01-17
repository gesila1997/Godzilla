package com.evan.indusfoserver.service;

import com.evan.indusfoserver.mapper.PNoMapper;
import com.evan.indusfoserver.pojo.PNo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PNoService {
    @Autowired
    private PNoMapper pNoMapper;

    public List<PNo> Pnoselect() {

        return pNoMapper.Pnoselect();
    }
}
