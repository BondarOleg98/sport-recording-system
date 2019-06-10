package com.olegb.client.Controller;

import com.olegb.client.Client.RestClient;
import com.olegb.client.Client.RestClientAddition;
import com.olegb.client.Model.Competition;
import com.olegb.client.Model.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/competition")
public class CompetitionController {

    @Autowired
    private RestClientAddition restClientAddition;

    @GetMapping
    public ModelAndView competitionList(){
        ModelAndView model = new ModelAndView("AllComp.jsp");
        model.addObject("Competitions",restClientAddition.competitionList());
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String authName =  auth.getName();
        model.addObject("user",authName);
        return model;
    }

    @PostMapping("/create")
    public ModelAndView createCompetition(Competition competition, @RequestParam("t") String fromDate){
        String name = competition.getName();
        competition.setT(name);
        competition.setName(fromDate);
        restClientAddition.createCompetition(competition);
        return new ModelAndView("redirect:/competition");

    }
    @GetMapping("/{id}")
    public ModelAndView OneCompetition(@PathVariable Integer id) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String authName =  auth.getName();
        ModelAndView model = new ModelAndView("DetailComp.jsp");
        model.addObject("user",authName);
        model.addObject("detailComp",restClientAddition.OneCompetition(id));
        return model;
    }
    @PostMapping("update/{id}")
    public ModelAndView replaceArt(Competition newCompetition, @PathVariable Integer id, @RequestParam("t") String fromDate) {
        String name = newCompetition.getName();
        newCompetition.setT(name);
        newCompetition.setName(fromDate);
        restClientAddition.replaceCompetition(newCompetition, id);
        return new ModelAndView("redirect:/competition/{id}");
    }

    @GetMapping("delete/{id}")
    public ModelAndView deleteCompetition(@PathVariable Integer id) {
        restClientAddition.deleteCompetition(id);
        return new ModelAndView("redirect:/competition");
    }
}
