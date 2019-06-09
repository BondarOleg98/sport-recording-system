package com.olegb.additionalService.Service.Contract;

import com.olegb.additionalService.Model.Competition;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface ICompetitionService {
    List<Competition> competitionList();
    void createCompetition(Competition competition);
    Competition OneCompetition(Integer id);
    void replaceCompetition(Competition newCompetition, Integer id);
    void deleteCompetition(Integer id);
}
