package com.evan.indusfoserver.service;

import com.evan.indusfoserver.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentService {

    void AddStudent(Student student);

    void delStudentById(@Param("id") int id);

    void updateStudentById(Student student);

    List<Student> getStudent();
}
