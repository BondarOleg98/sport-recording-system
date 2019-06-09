package com.olegb.service.Service;
import com.olegb.service.Controller.NotFoundException;
import com.olegb.service.Model.Schedule;
import com.olegb.service.Repository.ScheduleRepository;
import com.olegb.service.Service.Contracts.IScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class ScheduleService implements IScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private CoachService coachService;

    @Override
    public List<Schedule> getAllSchedules(){
        List<Schedule> schedules = scheduleRepository.findAll();
        return schedules;
    }

    @Override
    public Schedule createSchedule(Schedule schedule, Map<String,String> coach){
        String keyCoach = coach.get("indCoach");
        if(keyCoach!=null){
            schedule.setCoach(coachService.OneCoach(UUID.fromString(keyCoach)));
        }
        UUID uuid = UUID.randomUUID();
        schedule.setId(uuid);
        return scheduleRepository.save(schedule);

    }

    @Override
    public Schedule OneSchedule(UUID id) {
        return  scheduleRepository.findById(id).orElseThrow(() -> new NotFoundException("student", id));
    }

    @Override
    public Schedule replaceSchedule(Schedule newSchedule, UUID id, Map<String,String> coach) {
        String keyCoach = coach.get("indCoach");
        return scheduleRepository.findById(id)
                .map(schedule -> {
                    if(keyCoach!=null){
                        schedule.setCoach(coachService.OneCoach(UUID.fromString(keyCoach)));
                    }
                    else {
                        schedule.setCoach(null);
                    }
                    schedule.setTimeClass(newSchedule.getTimeClass());
                    schedule.setDay(newSchedule.getDay());
                    return scheduleRepository.save(schedule);
                })
                .orElseGet(() -> {
                    newSchedule.setId(id);
                    return scheduleRepository.save(newSchedule);
                });
    }

    @Override
    public Map<String, Boolean> deleteSchedule(UUID id) {
        Map<String, Boolean>response = new HashMap<>();
        if(!scheduleRepository.findById(id).isPresent()){
            response.put("Error 404: schedule not found",Boolean.FALSE);
            return response;
        } else {
            scheduleRepository.deleteById(id);
            response.put("Boolean",Boolean.TRUE);
            return response;
        }
    }

}
