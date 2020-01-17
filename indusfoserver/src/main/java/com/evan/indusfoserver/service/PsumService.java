package com.evan.indusfoserver.service;

import com.evan.indusfoserver.mapper.PsumMapper;
import com.evan.indusfoserver.pojo.Psum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PsumService {
    @Autowired
    private PsumMapper psumMapper;

    public List<Psum> Psumselect(){

      return  psumMapper.Psumselect();
    }
}
