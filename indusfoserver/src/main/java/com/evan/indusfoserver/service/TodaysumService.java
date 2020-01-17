package com.evan.indusfoserver.service;

import com.evan.indusfoserver.mapper.TodaysumMapper;
import com.evan.indusfoserver.pojo.Todaysum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodaysumService {
    @Autowired
    private TodaysumMapper todaysumMapper;

    public List<Todaysum> Todayselect() {
        return todaysumMapper.Todayselect();
    }
}
