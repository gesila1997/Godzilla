package com.evan.indusfoserver.mapper;

import com.evan.indusfoserver.pojo.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentMapper {
    @Insert({"insert into Student(id, username, password) values(#{id}, #{username}, #{password})"})
    void AddStudent(Student studentInfo);

    @Delete("delete from Student where id=#{id}")
    void delStudentById(@Param("id") int id);

    @Update("update Student set username = #{username}, password = #{password} where id = #{id}")
    void updateStudentByID(@Param("username") String username, @Param("password") String password, @Param("id") int id);

    @Select("SELECT id,username,password,sex FROM student")
    List<Student> getStudent();
}
