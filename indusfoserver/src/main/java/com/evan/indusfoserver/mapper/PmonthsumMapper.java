package com.evan.indusfoserver.mapper;


import com.evan.indusfoserver.pojo.Pmonthsum;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PmonthsumMapper {
    @Select("SELECT \n" +
            "p.sum,\n" +
            "CASE p.time \n" +
            "WHEN '01' THEN '1月'\n" +
            "WHEN '02' THEN '2月'\n" +
            "WHEN '03' THEN '3月'\n" +
            "WHEN '04' THEN '4月'\n" +
            "WHEN '05' THEN '5月'\n" +
            "WHEN '06' THEN '6月'\n" +
            "WHEN '07' THEN '7月'\n" +
            "WHEN '08' THEN '8月'\n" +
            "WHEN '09' THEN '9月'\n" +
            "WHEN '10' THEN '10月'\n" +
            "WHEN '11' THEN '11月'\n" +
            "WHEN '12' THEN '12月'  ELSE '' END AS time\n" +
            "FROM (SELECT RIGHT(DATE_FORMAT(Acctime,'%Y-%m'),2) as time,sum(madeNumb) AS sum FROM product_bgtext  GROUP BY  time) p ORDER BY  p.time desc LIMIT 5")
    List<Pmonthsum> Pmoselect();
}
