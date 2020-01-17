package com.evan.indusfoserver.mapper;

import com.evan.indusfoserver.pojo.PNo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PNoMapper {

    @Select("SELECT RIGHT(times,5) as times, no1, no2, no3 FROM text ORDER BY times DESC LIMIT 5")
    List<PNo>  Pnoselect();

}
