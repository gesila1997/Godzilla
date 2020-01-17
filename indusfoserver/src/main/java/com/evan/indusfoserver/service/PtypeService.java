package com.evan.indusfoserver.service;

import com.evan.indusfoserver.mapper.PtypeMapper;
import com.evan.indusfoserver.pojo.Ptype;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PtypeService {
    @Autowired
    private PtypeMapper ptypeMapper;

    public List<Ptype> select() {
        return ptypeMapper.select();
    }


}
