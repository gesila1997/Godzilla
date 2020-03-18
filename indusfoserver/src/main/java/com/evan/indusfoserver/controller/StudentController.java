package com.evan.indusfoserver.controller;

import com.evan.indusfoserver.pojo.Student;
import com.evan.indusfoserver.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Scope("prototype")
@CrossOrigin
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping(value = "/api/StudentList")
    public List<Student> StudentList() throws Exception {
        return studentService.getStudent();
    }

    @PostMapping(value ="/api/addStudent")
    public void StudentAdd(Student student){
        studentService.AddStudent(student);
    }

    @PutMapping(value ="/api/updateStudent")
    public void StudentUpdate(Student student){
        studentService.updateStudentById(student);
    }

    @DeleteMapping(value ="/api/delStudent")
    public void StudentDel(@RequestParam(value="id") int id){
        studentService.delStudentById(id);
    }
}
