package com.evan.indusfoserver.service;

import com.evan.indusfoserver.mapper.PmonthsumMapper;
import com.evan.indusfoserver.pojo.Pmonthsum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PmonthsumService {

    @Autowired
    private PmonthsumMapper pmonthsumMapper;

    public List<Pmonthsum> Pmoselect(){

        return pmonthsumMapper.Pmoselect();
    }

}
