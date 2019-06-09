package com.olegb.service.Controller;

import com.olegb.service.Model.Coach;
//import com.olegb.service.Service.ArtService;
import com.olegb.service.Service.CoachService;
//import com.olegb.service.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.UUID;

//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.cloud.context.config.annotation.RefreshScope;

@RestController
@RequestMapping("/coach")
public class CoachController {

    @Autowired
    private CoachService coachService;


    @GetMapping
    public List<Coach> getAllCoaches(){

        return coachService.getAllCoaches();
    }

    @PostMapping("/create")
    public Coach createCoach(@RequestBody @Valid Coach coach, @RequestParam Map<String,String> art){


        return coachService.createCoach(coach,art);
    }

    @GetMapping("/{id}")
    public Coach OneCoach(@PathVariable UUID id) {

        return coachService.OneCoach(id);
    }
    @PostMapping("update/{id}")
    public Coach replaceCoach(@RequestBody @Valid Coach newCoach, @PathVariable UUID id,  @RequestParam Map<String,String> art) {

        return coachService.replaceCoach(newCoach, id,art);
    }

    @GetMapping("delete/{id}")
    public void deleteCoach(@PathVariable UUID id) {
        coachService.deleteCoach(id);
    }

}
