package com.evan.indusfoserver.mapper;

import com.evan.indusfoserver.pojo.Contractordata;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ContractordataMapper {

    @Select("SELECT PoId,Mtype,LEFT(client,5) AS Client,Acctime,No,GetNum,DamageNum,madeNumb,sampleNumb,\n" +
            "samplecount,Duihua,Daoxian,Jietou,Dazou,Other FROM product_bgtext")
    List<Contractordata> Conselect();
}
