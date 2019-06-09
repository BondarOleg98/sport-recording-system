package com.olegb.service.Service;

import com.olegb.service.Controller.NotFoundException;
import com.olegb.service.Model.Coach;
import com.olegb.service.Model.Schedule;
import com.olegb.service.Model.Student;
import com.olegb.service.Repository.CoachRepository;
import com.olegb.service.Repository.ScheduleRepository;
import com.olegb.service.Repository.StudentRepository;
import com.olegb.service.Service.Contracts.ICoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CoachService implements ICoachService {

    @Autowired
    private CoachRepository coachRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private ArtService artService;

    @Override
    public List<Coach> getAllCoaches(){

        return coachRepository.findAll();
    }

    @Override
    public Coach createCoach(Coach coach, Map<String,String>art){
        String key = art.get("indArt");
        if(key!=null){
            coach.setArtStyle(artService.OneArt(UUID.fromString(key)));
        }
        UUID uuid = UUID.randomUUID();
        coach.setId(uuid);
        return coachRepository.save(coach);
    }

    @Override
    public Coach OneCoach(UUID id) {
        return coachRepository.findById(id).orElseThrow(() -> new NotFoundException("coach", id));
    }

    @Override
    public Coach replaceCoach(Coach newCoach, UUID id, Map<String,String>art) {
        String key = art.get("indArt");
        return coachRepository.findById(id)
                .map(coach -> {
                    if(key!=null){
                        coach.setArtStyle(artService.OneArt(UUID.fromString(key)));
                    }
                    else {
                        coach.setArtStyle(null);
                    }
                    coach.setName(newCoach.getName());
                    coach.setSurname(newCoach.getSurname());
                    coach.setAge(newCoach.getAge());
                    coach.setRank(newCoach.getRank());
                    coach.setMail(newCoach.getMail());
                    return coachRepository.save(coach);
                }).orElseGet(() -> {
                    newCoach.setId(id);
                    return coachRepository.save(newCoach);
                });

    }
    @Override
    public Map<String, Boolean> deleteCoach(UUID id) {
        Map<String, Boolean>response = new HashMap<>();
        if(!coachRepository.findById(id).isPresent()){
            response.put("Error 404: coach not found",Boolean.FALSE);
            return response;
        } else {
            List<Student> students = new ArrayList<>();
            List<Schedule> schedules = new ArrayList<>();
            students = studentRepository.findAll();
            schedules = scheduleRepository.findAll();
            for (Student student:students) {
                if(student.getArtStyle()!=null){
                    if(student.getCoach().getId().toString().equals(id.toString())){
                        student.setCoach(null);
                    }
                }
            }
            for (Schedule schedule:schedules) {
                if(schedule.getCoach().getId().toString().equals(id.toString())){
                    schedule.setCoach(null);
                }
            }
            coachRepository.deleteById(id);
            response.put("Boolean",Boolean.TRUE);
            return response;
        }
    }
}
