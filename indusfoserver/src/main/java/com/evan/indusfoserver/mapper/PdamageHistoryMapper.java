package com.evan.indusfoserver.mapper;

import com.evan.indusfoserver.pojo.Pdamage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PdamageHistoryMapper {
    @Select(" SELECT SUM(ACC.AA) AS duihua,SUM(ACC.AB) AS daoxian,SUM(ACC.AC) AS jietou,SUM(ACC.AD) AS dazou FROM (\n" +
            " SELECT AC.Acctime AS ACA,\n" +
            "             CASE WHEN AC.A >0 THEN A ELSE 0 END AS AA,\n" +
            "             CASE WHEN AC.B >0 THEN B ELSE 0 END AS AB,\n" +
            "             CASE WHEN AC.C >0 THEN C ELSE 0 END AS AC, \n" +
            "             CASE WHEN AC.D >0 THEN D ELSE 0 END AS AD\n" +
            "             FROM ( \n" +
            "            SELECT Acctime,Sum(Duihua) AS A,Sum(Daoxian) AS B,Sum(Jietou) AS C,Sum(Dazou) AS D FROM product_bgtext GROUP BY Acctime ORDER BY Acctime ) AC) ACC")
    List<Pdamage> PHiselect();
}
