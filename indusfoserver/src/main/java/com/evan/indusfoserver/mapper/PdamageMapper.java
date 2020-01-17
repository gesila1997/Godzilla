package com.evan.indusfoserver.mapper;

import com.evan.indusfoserver.pojo.Pdamage;
import com.evan.indusfoserver.pojo.Pmonthsum;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PdamageMapper {
    @Select("\t\t SELECT \n" +
            "             CASE WHEN AC.A >0 THEN A ELSE 0 END AS duihua,\n" +
            "             CASE WHEN AC.B >0 THEN B ELSE 0 END AS daoxian,\n" +
            "             CASE WHEN AC.C >0 THEN C ELSE 0 END AS jietou, \n" +
            "             CASE WHEN AC.D >0 THEN D ELSE 0 END AS dazou\n" +
            "             FROM ( \n" +
            "             SELECT Acctime,Sum(Duihua) AS A,Sum(Daoxian) AS B,Sum(Jietou) AS C,Sum(Dazou) AS D FROM product_bgtext GROUP BY Acctime ORDER BY Acctime ) AC \n" +
            "\t\t\t\t\t   ORDER BY AC.Acctime\tDESC LIMIT 1")
    List<Pdamage> Pdaselect();
}
