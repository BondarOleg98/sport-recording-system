package com.olegb.service.Controller;

import com.olegb.service.Model.Log;
import com.olegb.service.Model.Student;
import com.olegb.service.Service.ArtService;
import com.olegb.service.Service.CoachService;
import com.olegb.service.Service.StudentService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    AmqpTemplate amqpTemplate;

    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<Student> getAllStudents(){

        return studentService.getAllStudents();
    }

    @PostMapping("/create")
    public Student createStudent(@RequestBody @Valid Student student, @RequestParam Map<String,String> artCoach){

        return studentService.createStudent(student,artCoach);

    }
    @GetMapping("/{id}")
    public Student OneStudent(@PathVariable UUID id) {
        return studentService.OneStudent(id);
    }
    @PostMapping("update/{id}")
    public Student replaceStudent(@RequestBody @Valid Student newStudent, @PathVariable UUID id, @RequestParam Map<String,String>artCoach) {
        return  studentService.replaceStudent(newStudent, id,artCoach);
    }

    @GetMapping("delete/{id}")
    public void deleteStudent(@PathVariable UUID id) {
        studentService.deleteStudent(id);
    }


}
