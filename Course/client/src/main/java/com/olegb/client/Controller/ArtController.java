package com.olegb.client.Controller;

import com.olegb.client.Client.RestClient;
import com.olegb.client.Model.*;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/art")
public class ArtController {
    @Autowired
    private RestClient restClient;

    @Autowired
    private AmqpTemplate amqpTemplate;

    @GetMapping
    public ModelAndView getAllArts(){
        ModelAndView model = new ModelAndView("AllArt.jsp");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String authName =  auth.getName();
        model.addObject("user",authName);
        model.addObject("ListArt",restClient.getAllArts());
        Date date = new Date();
        amqpTemplate.convertAndSend("GetArts", new Log("GetArts",date));
        return model;
    }

    @PostMapping("/create")
    public ModelAndView createArt(ArtStyle art){
        restClient.createArt(art);
        Date date = new Date();
        amqpTemplate.convertAndSend("CreateArt", new Log("CreateArt",date));
        return new ModelAndView("redirect:/art");

    }
    @GetMapping("/{id}")
    public ModelAndView OneArt(@PathVariable UUID id) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String authName =  auth.getName();
        ModelAndView model = new ModelAndView("DetailArts.jsp");
        model.addObject("user",authName);

        model.addObject("detailArts",restClient.OneArt(id));
        List<Coach> coaches = new ArrayList<>();
        for (Coach coach:restClient.getAllCoaches()) {
            if(coach.getArtStyle()!=null){
                if(coach.getArtStyle().getId().toString().equals(id.toString())){
                    coaches.add(coach);
                }
            }
        }
        List<Student> students = new ArrayList<>();
        for (Student student:restClient.getAllStudents()) {
            if(student.getArtStyle()!=null){
                if(student.getArtStyle().getId().toString().equals(id.toString())){
                    students.add(student);
                }
            }
        }
        model.addObject("chooseCoaches",coaches);
        model.addObject("chooseStudents",students);
        Date date = new Date();
        amqpTemplate.convertAndSend("GetOneArt", new Log("GetOneArt",date));
        return model;
    }
    @PostMapping("update/{id}")
    public ModelAndView replaceArt( ArtStyle newArt, @PathVariable UUID id) {
        restClient.replaceArt(newArt, id);
        Date date = new Date();
        amqpTemplate.convertAndSend("UpdateArt", new Log("UpdateArt",date));
        return new ModelAndView("redirect:/art/{id}");
    }

    @GetMapping("delete/{id}")
    public ModelAndView deleteArt(@PathVariable UUID id) {
        restClient.deleteArt(id);

        Date date = new Date();
        amqpTemplate.convertAndSend("RemoveArt", new Log("RemoveArt",date));
        return new ModelAndView("redirect:/art");
    }
}
