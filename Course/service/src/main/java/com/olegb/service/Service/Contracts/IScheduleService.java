package com.olegb.service.Service.Contracts;

import com.olegb.service.Model.Schedule;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface IScheduleService {
    List<Schedule> getAllSchedules();
    Schedule createSchedule(Schedule student, Map<String, String> coach);
    Schedule OneSchedule(UUID id);
    Schedule replaceSchedule(Schedule newSchedule, UUID id, Map<String, String> coach);
    Map<String, Boolean> deleteSchedule(UUID id);
}
