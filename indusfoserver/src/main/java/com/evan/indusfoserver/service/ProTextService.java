package com.evan.indusfoserver.service;

import com.evan.indusfoserver.mapper.ProTextMapper;
import com.evan.indusfoserver.pojo.ProText;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProTextService {
    @Autowired
    private ProTextMapper proTextMapper;

    public List<ProText> Proselect(){
        return proTextMapper.Proselect();
    }
}
