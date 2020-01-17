package com.evan.indusfoserver.mapper;
import com.evan.indusfoserver.pojo.Todaysum;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TodaysumMapper {

    @Select("SELECT CONCAT(LEFT(AB.prac*100/AB.plans,4),'%') AS ratio,AB.plans,AB.prac \n" +
            "FROM (SELECT SUM(AA.MN) AS plans,SUM(AA.nmber) AS prac  \n" +
            "FROM (SELECT  A.PO,A.PrdtName,A.SO,B.Mcount AS MN,CASE WHEN A.PoStatus='已完工' THEN (SELECT FQTY FROM sttm WHERE PO = A.PO) \n" +
            "ELSE 0  END AS nmber  FROM  c02_po  A ,(SELECT SO,PrdtName,Mcount FROM  C01_SO where Jdate = '2019/12/24' ) B  WHERE A.SO = B.SO) AA) AB")
    List<Todaysum> Todayselect();
}