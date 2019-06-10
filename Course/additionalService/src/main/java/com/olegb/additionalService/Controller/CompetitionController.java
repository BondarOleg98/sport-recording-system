package com.olegb.additionalService.Controller;

import com.olegb.additionalService.Model.Competition;
import com.olegb.additionalService.Service.CompetitionService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/competition")
public class CompetitionController {

    @Autowired
    private CompetitionService competitionService;

    @GetMapping
    public List<Competition> competitionList(){
       return  competitionService.competitionList();
    }
    @PostMapping("/create")
    public void createCompetition(@RequestBody @Valid Competition competition){

      competitionService.createCompetition(competition);
    }
    @GetMapping("/{id}")
    public Competition  OneCompetition(@PathVariable Integer id){
        return  competitionService.OneCompetition(id);
    }
    @PostMapping("/update/{id}")
    public void replaceCompetition(@RequestBody @Valid Competition competition, @PathVariable Integer id){
        competitionService.replaceCompetition(competition,id);
    }
    @PostMapping("/delete/{id}")
    public void deleteCompetition(@PathVariable Integer id){
        competitionService.deleteCompetition(id);
    }


}
