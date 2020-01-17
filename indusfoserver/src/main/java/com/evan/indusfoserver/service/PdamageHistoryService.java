package com.evan.indusfoserver.service;

import com.evan.indusfoserver.mapper.PdamageHistoryMapper;
import com.evan.indusfoserver.pojo.Pdamage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class PdamageHistoryService {
    @Autowired
    private PdamageHistoryMapper pdamageHistoryMapper;

    @GetMapping(value = "/api/PHiselect")
    public List<Pdamage> PHiselect() throws Exception {
        return pdamageHistoryMapper.PHiselect();
    }

}
