package com.olegb.client.Controller;

import com.olegb.client.Model.*;
import com.olegb.client.Client.RestClient;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@RestController
@RequestMapping("/coach")
public class CoachController {

    @Autowired
    private RestClient restClient;

    @Autowired
    private AmqpTemplate amqpTemplate;

    @GetMapping
    public ModelAndView getAllCoaches(){
        ModelAndView model = new ModelAndView("AllCoaches.jsp");
        model.addObject("ListCoaches",restClient.getAllCoaches());
        model.addObject("ListArts",restClient.getAllArts());
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String val = restClient.getServiceColor();
        String authName =  auth.getName();
        model.addObject("user",authName);
        Config color = new Config();
        color.setName(val);
        model.addObject("color",color);

        Date date = new Date();
        amqpTemplate.convertAndSend("GetCoaches", new Log("GetCoaches",date));
        return model;
    }


    @PostMapping("/create")
    public ModelAndView createCoach(Coach coach, @RequestParam Map<String,String> art){
        restClient.createCoach(coach,art);
        Date date = new Date();
        amqpTemplate.convertAndSend("CreateCoach", new Log("CreateCoach",date));
        return new ModelAndView("redirect:/coach");
    }
    @GetMapping("/{id}")
    public ModelAndView OneCoach(@PathVariable UUID id) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String authName =  auth.getName();
        ModelAndView model = new ModelAndView("DetailCoaches.jsp");
        model.addObject("user",authName);
        model.addObject("detailCoaches",restClient.OneCoach(id));
        List<Student> students = new ArrayList<>();
        for (Student student:restClient.getAllStudents()) {
            if(student.getCoach()!=null){
                if(student.getCoach().getId().toString().equals(id.toString())){
                    students.add(student);
                }
            }
        }
        model.addObject("chooseStudent",students);
        model.addObject("ListArts",restClient.getAllArts());
        Date date = new Date();
        amqpTemplate.convertAndSend("GetOneCoach", new Log("GetOneCoach",date));
        return model;
    }
    @PostMapping("update/{id}")
    public ModelAndView replaceCoach(Coach newCoach, @PathVariable UUID id,  @RequestParam Map<String,String> art) {
        restClient.replaceCoach(newCoach, id,art);
        Date date = new Date();
        amqpTemplate.convertAndSend("UpdateCoach", new Log("UpdateCoach",date));
        return new ModelAndView("redirect:/coach/{id}");
    }

    @GetMapping("delete/{id}")
    public ModelAndView deleteCoach(@PathVariable UUID id) {
        restClient.deleteCoach(id);
        Date date = new Date();
        amqpTemplate.convertAndSend("RemoveCoach", new Log("RemoveCoach",date));
        return new ModelAndView("redirect:/coach");
    }

}
