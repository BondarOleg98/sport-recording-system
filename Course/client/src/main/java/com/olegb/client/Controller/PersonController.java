package com.olegb.client.Controller;

import com.olegb.client.Client.RestClient;
import com.olegb.client.Client.RestClientFunctional;
import com.olegb.client.Model.Coach;
import com.olegb.client.Model.PersonalArea;
import com.olegb.client.Model.Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;
import java.util.concurrent.ScheduledExecutorService;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private RestClientFunctional restClientFunctional;

    @Autowired
    private RestClient restClient;

    @PostMapping("/create")
    public ModelAndView createPerson(PersonalArea personalArea, @RequestParam Map<String,String> coach){
        String keyLesson = coach.get("lessonId");
        List<Schedule> schedules = new ArrayList<>();
        if(keyLesson!=null){
            schedules.add(restClient.OneSchedule(UUID.fromString(keyLesson)));
        }
        personalArea.setSchedules(schedules);
        personalArea.setFlag(0);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String authName =  auth.getName();
        personalArea.setName(authName);
        restClientFunctional.createPerson(personalArea);
        return new ModelAndView("redirect:/personal");
    }
    @PostMapping("/confirm/{id}")
    public ModelAndView Confirm(@PathVariable UUID id){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String authName =  auth.getName();
        List<PersonalArea> personalAreaList = restClientFunctional.ListPerson();
        List<String> username = new ArrayList<>();
        for (PersonalArea personal:personalAreaList) {
            for (Schedule schedule:personal.getSchedules()) {
                if(schedule.getCoach().getMail().equals(authName)){
                    if (!username.contains(personal.getName()))
                        username.add(personal.getName());
                }
            }
        }
        for (String user: username) {
            restClientFunctional.confirm(user,id);
        }

        return new ModelAndView("redirect:/personal");
    }
    @PostMapping("/reject/{id}")
    public ModelAndView Reject(@PathVariable UUID id){

        List<PersonalArea> listPerson = restClientFunctional.ListPerson();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        List<String> username = new ArrayList<>();
        for (PersonalArea personal:listPerson) {
            for (Schedule schedule:personal.getSchedules()) {
                if(schedule.getCoach().getMail().equals(auth.getName())){
                    if (!username.contains(personal.getName()))
                        username.add(personal.getName());
                }
            }
        }
        for (String user: username) {
            restClientFunctional.reject(user,id);
        }

        return new ModelAndView("redirect:/personal");
    }
}
