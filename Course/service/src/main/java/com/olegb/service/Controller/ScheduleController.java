package com.olegb.service.Controller;
import com.olegb.service.Model.Schedule;
import com.olegb.service.Service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @GetMapping
    public List<Schedule> getAllSchedule(){

        return scheduleService.getAllSchedules();
    }

    @PostMapping("/create")
    public Schedule createSchedule(@RequestBody @Valid Schedule schedule, @RequestParam Map<String,String> coach){

        return scheduleService.createSchedule(schedule,coach);

    }
    @GetMapping("/{id}")
    public Schedule OneSchedule(@PathVariable UUID id) {
        return scheduleService.OneSchedule(id);
    }
    @PostMapping("update/{id}")
    public Schedule replaceSchedule(@RequestBody @Valid Schedule newSchedule, @PathVariable UUID id, @RequestParam Map<String,String> coach) {
        return  scheduleService.replaceSchedule(newSchedule, id, coach);
    }

    @GetMapping("delete/{id}")
    public void deleteSchedule(@PathVariable UUID id) {
        scheduleService.deleteSchedule(id);
    }
}
