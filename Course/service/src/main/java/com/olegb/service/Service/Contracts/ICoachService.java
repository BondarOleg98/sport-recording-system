package com.olegb.service.Service.Contracts;

import com.olegb.service.Model.Coach;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface ICoachService {
    List<Coach> getAllCoaches();
    Coach createCoach(Coach coach, Map<String, String> art);
    Coach OneCoach(UUID id);
    Coach replaceCoach(Coach newCoach, UUID id, Map<String, String> art);
    Map<String, Boolean> deleteCoach(UUID id);
}
