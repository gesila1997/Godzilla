package com.evan.indusfoserver.service.serviceImpl;

import com.evan.indusfoserver.mapper.StudentMapper;
import com.evan.indusfoserver.pojo.Student;
import com.evan.indusfoserver.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentMapper studentMapper;

    @Override
    public void AddStudent(Student student) {
        studentMapper.AddStudent(student);
    }

    @Override
    public void delStudentById(int id) {
        studentMapper.delStudentById(id);
    }

    @Override
    public void updateStudentById(Student student) {
        studentMapper.updateStudentByID(student.getUsername(),student.getPassword(),student.getId());
    }

    @Override
    public List<Student> getStudent() {

        List<Student> studentList = studentMapper.getStudent();

        Collections.sort(studentList,(Student1, Student2) -> Student1.getId() - Student2.getId());

        return studentList;
    }
}
