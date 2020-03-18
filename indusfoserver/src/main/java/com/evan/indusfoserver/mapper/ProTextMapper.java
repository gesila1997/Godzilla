package com.evan.indusfoserver.mapper;
import com.evan.indusfoserver.pojo.ProText;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ProTextMapper {
    @Select("SELECT po,cname,prdtname,cdate,jdate,mcount,fqty,postatus,permark FROM c03_text")
    List<ProText> Proselect();
}
