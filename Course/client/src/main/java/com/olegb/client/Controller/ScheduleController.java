package com.olegb.client.Controller;

import com.olegb.client.Client.RestClient;
import com.olegb.client.Model.Config;
import com.olegb.client.Model.Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {

    @Autowired
    private RestClient restClient;

    @GetMapping
    public ModelAndView getAllSchedules(){
        ModelAndView model = new ModelAndView("Schedule.jsp");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String authName =  auth.getName();
        model.addObject("user",authName);
        model.addObject("ListSchedule",restClient.getAllSchedule());
        model.addObject("ListCoaches",restClient.getAllCoaches());
        return model;
    }

    @PostMapping("/create")
    public ModelAndView createSchedule(Schedule schedule, @RequestParam Map<String,String> coach,
                                       @RequestParam("selected_time") String fromDate){
        schedule.setTimeClass(fromDate);
        restClient.createSchedule(schedule,coach);
        return new ModelAndView("redirect:/schedule");

    }
    @GetMapping("/{id}")
    public ModelAndView OneSchedule(@PathVariable UUID id) {
        ModelAndView model = new ModelAndView("DetailSchedule.jsp");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String authName =  auth.getName();
        model.addObject("user",authName);
        model.addObject("detailSchedule",restClient.OneSchedule(id));
        model.addObject("ListCoaches",restClient.getAllCoaches());
        return model;
    }
    @PostMapping("update/{id}")
    public ModelAndView replaceSchedule(Schedule newSchedule, @PathVariable UUID id, @RequestParam Map<String,String>coach,
                                        @RequestParam("selected_time") String fromDate) {
        newSchedule.setTimeClass(fromDate);
        restClient.replaceSchedule(newSchedule, id,coach);
        return new ModelAndView("redirect:/schedule/{id}");
    }

    @GetMapping("delete/{id}")
    public ModelAndView deleteSchedule(@PathVariable UUID id) {
        restClient.deleteSchedule(id);
        return new ModelAndView("redirect:/schedule");
    }
}
