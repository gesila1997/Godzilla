package com.evan.indusfoserver.mapper;


import com.evan.indusfoserver.pojo.Ptype;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PtypeMapper  {

    @Select("SELECT productForm AS ProductName,COUNT(productName) AS Rate  FROM product_type  GROUP BY productForm")
    List<Ptype> select();


}
