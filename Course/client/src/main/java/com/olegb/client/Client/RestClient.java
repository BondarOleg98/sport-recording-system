package com.olegb.client.Client;

import com.olegb.client.Model.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@FeignClient("service")
public interface RestClient {

    @GetMapping("/service")
    String getServiceColor();

    @GetMapping("/log")
    List<Log> getAllLogs();

    @GetMapping("/log/delete")
    void deleteLog();

    @GetMapping("/coach")
    List<Coach> getAllCoaches();

    @PostMapping("/coach/create")
    Coach createCoach(Coach coach,@RequestParam Map<String,String> art);

    @GetMapping("/coach/{id}")
    Coach OneCoach(@PathVariable UUID id);

    @PostMapping("/coach/update/{id}")
    Coach replaceCoach( Coach newCoach, @PathVariable UUID id, @RequestParam Map<String,String> art);

    @GetMapping("/coach/delete/{id}")
    Map<String, Boolean> deleteCoach(@PathVariable UUID id);

    @GetMapping("/student")
    List<Student> getAllStudents();

    @PostMapping("/student/create")
    Student createStudent( Student student, @RequestParam Map<String,String> artCoach);

    @GetMapping("/student/{id}")
    Student OneStudent(@PathVariable UUID id);

    @PostMapping("/student/update/{id}")
    Student replaceStudent( Student newStudent, @PathVariable UUID id,  @RequestParam Map<String,String>artCoach);

    @GetMapping("/student/delete/{id}")
    Student deleteStudent(@PathVariable UUID id);

    @GetMapping("/art")
    List<ArtStyle> getAllArts();

    @PostMapping("/art/create")
    ArtStyle createArt( ArtStyle art);

    @GetMapping("/art/{id}")
    ArtStyle OneArt(@PathVariable UUID id);

    @PostMapping("/art/update/{id}")
    ArtStyle replaceArt(ArtStyle newArt, @PathVariable UUID id);

    @GetMapping("/art/delete/{id}")
    ArtStyle deleteArt(@PathVariable UUID id);

    @GetMapping("/schedule")
    List<Schedule> getAllSchedule();

    @PostMapping("/schedule/create")
    Schedule createSchedule(Schedule schedule, @RequestParam Map<String,String> coach);

    @GetMapping("/schedule/{id}")
    Schedule OneSchedule(@PathVariable UUID id);

    @PostMapping("/schedule/update/{id}")
    Schedule replaceSchedule( Schedule newSchedule, @PathVariable UUID id,  @RequestParam Map<String,String> coach);

    @GetMapping("/schedule/delete/{id}")
    Schedule deleteSchedule(@PathVariable UUID id);

}
