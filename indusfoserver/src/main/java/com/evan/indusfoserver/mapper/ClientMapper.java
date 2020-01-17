package com.evan.indusfoserver.mapper;


import com.evan.indusfoserver.pojo.Client;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ClientMapper {

    @Select("SELECT AD.A AS 'name',COUNT(*) AS 'value' FROM (SELECT LEFT(addr,2) as A FROM Client) AD GROUP BY AD.A")
    List<Client> PClselect();

}
