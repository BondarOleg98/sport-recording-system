package com.olegb.client.Controller;
;
import com.olegb.client.Client.RestClient;
import com.olegb.client.Client.RestClientAddition;
import com.olegb.client.Client.RestClientFunctional;
import com.olegb.client.Model.Coach;
import com.olegb.client.Model.Competition;
import com.olegb.client.Model.PersonalArea;
import com.olegb.client.Model.Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.*;
import java.util.stream.Collectors;

@RestController
public class PersonalController {

    @Autowired
    private RestClientAddition restClientAddition;

    @Autowired
    private RestClientFunctional restClientFunctional;

    @Autowired
    private RestClient restClient;


    @PostMapping("/personal/create")
    public ModelAndView createPersonal(PersonalArea personalArea, @RequestParam Map<String,String> competition){
        Set<String> keySet = competition.keySet();
        List<Competition> competitions = new ArrayList<>();
        for (String choose:keySet) {
            competitions.add(restClientAddition.OneCompetition(Integer.parseInt(choose)));
        }
        personalArea.setCompetitions(competitions);

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String authName =  auth.getName();
        personalArea.setName(authName);
        restClientAddition.createPersonal(personalArea);
        return new ModelAndView("redirect:/personal");
    }

    @GetMapping("/personal")
    public ModelAndView OnePersonal() {
        ModelAndView model = new ModelAndView("PersonalArea.jsp");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String authName =  auth.getName();
        model.addObject("ListCompetition",restClientAddition.competitionList());
        model.addObject("ListLesson",restClient.getAllSchedule());
        model.addObject("name",authName);

        PersonalArea personal = new PersonalArea();
        Set<String> role = auth.getAuthorities().stream().map(u-> u.getAuthority()).collect(Collectors.toSet());
        List<PersonalArea> personalAreas = restClientAddition.ListPersonal();
        List<PersonalArea> personalAreaList = restClientFunctional.ListPerson();

        String temp =null;
        for (String Role:role) {
             temp = Role;
        }
        for (PersonalArea personalArea:personalAreas) {
            if(personalArea.getName().equals(authName)){
                personal=personalArea;
            }
        }
        //boolean flag = false;
        List<String> message = new ArrayList<>();
        if(temp.equals("USER")){
            for (PersonalArea personalArea:personalAreaList) {
                if(personalArea.getName().equals(authName)&(personalArea.getFlag()==1)){
                    personal=personalArea;
                }
            }

        }
        List<PersonalArea> person = new ArrayList<>();
        if(temp.equals("COACH")){
            for (PersonalArea personalArea:personalAreaList) {
                for (Schedule schedule:personalArea.getSchedules()) {
                    if(schedule.getCoach().getMail().equals(authName)&(personalArea.getFlag()==0)){
                        person.add(personalArea);
                    }


                }
            }
        }
        model.addObject("message",message);
        model.addObject("Apply",person);
        model.addObject("role",temp);
        model.addObject("FutureEvent",personal);
        return model;
    }
}
