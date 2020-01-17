package com.evan.indusfoserver.mapper;


import com.evan.indusfoserver.pojo.Psum;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PsumMapper {

    @Select("SELECT RIGHT(pcompletetime,5) AS 'Time',SUM(plannumber) AS Pnum,SUM(actualnumber) AS Anum, LEFT(SUM(actualnumber)/SUM(plannumber),5) AS Num FROM product_pcomplete GROUP BY pcompletetime ORDER BY pcompletetime DESC LIMIT 5")
    List<Psum> Psumselect();

}
