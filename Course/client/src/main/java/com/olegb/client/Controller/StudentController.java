package com.olegb.client.Controller;

import com.olegb.client.Model.Log;
import com.olegb.client.Model.Student;
import com.olegb.client.Client.RestClient;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Autowired
    private RestClient restClient;

    @GetMapping
    public ModelAndView getAllStudents(){
        ModelAndView model = new ModelAndView("AllStudents.jsp");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String authName =  auth.getName();
        model.addObject("user",authName);
        model.addObject("ListStudents",restClient.getAllStudents());
        model.addObject("ListCoaches",restClient.getAllCoaches());
        model.addObject("ListArts",restClient.getAllArts());
        Date date = new Date();
        amqpTemplate.convertAndSend("GetStudents", new Log("GetStudents",date));
        return model;
    }

    @PostMapping("/create")
    public ModelAndView createStudent(Student student, @RequestParam Map<String,String> artCoach){
        restClient.createStudent(student,artCoach);
        Date date = new Date();
        amqpTemplate.convertAndSend("CreateStudent", new Log("CreateStudent",date));
        return new ModelAndView("redirect:/student");

    }
    @GetMapping("/{id}")
    public ModelAndView OneStudent(@PathVariable UUID id) {
        ModelAndView model = new ModelAndView("DetailStudents.jsp");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String authName =  auth.getName();

        model.addObject("user",authName);
        model.addObject("detailStudents",restClient.OneStudent(id));
        model.addObject("ListArts",restClient.getAllArts());
        model.addObject("ListCoaches",restClient.getAllCoaches());
        Date date = new Date();
        amqpTemplate.convertAndSend("GetOneStudent", new Log("GetOneStudent",date));
        return model;
    }
    @PostMapping("update/{id}")
    public ModelAndView replaceStudent(Student newStudent, @PathVariable UUID id, @RequestParam Map<String,String>artCoach) {
        restClient.replaceStudent(newStudent, id,artCoach);
        Date date = new Date();
        amqpTemplate.convertAndSend("UpdateStudent", new Log("UpdateStudent",date));
        return new ModelAndView("redirect:/student/{id}");
    }

    @GetMapping("delete/{id}")
    public ModelAndView deleteStudent(@PathVariable UUID id) {
        restClient.deleteStudent(id);
        Date date = new Date();
        amqpTemplate.convertAndSend("RemoveStudent", new Log("RemoveStudent",date));
        return new ModelAndView("redirect:/student");
    }


}
