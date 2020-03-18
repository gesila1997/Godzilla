package com.evan.indusfoserver.controller;

import com.evan.indusfoserver.pojo.Todaysum;
import com.evan.indusfoserver.service.TodaysumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Scope("prototype")
@CrossOrigin
public class TodaysumController {
    @Autowired
    private TodaysumService todaysumService;

    @GetMapping(value = "/api/Todayselect")
    public List<Todaysum> Todayselect() throws Exception {
        return todaysumService.Todayselect();
    }
}
