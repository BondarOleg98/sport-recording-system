package com.olegb.additionalService.Service;

import com.olegb.additionalService.Controller.NotFoundException;
import com.olegb.additionalService.Model.Competition;
import com.olegb.additionalService.Model.PersonalArea;
import com.olegb.additionalService.Repository.CompetitionRepository;
import com.olegb.additionalService.Repository.PersonalRepository;
import com.olegb.additionalService.Service.Contract.ICompetitionService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CompetitionService implements ICompetitionService {

    @Autowired
    private CompetitionRepository competitionRepository;

    @Autowired
    private PersonalRepository personalRepository;

    @Autowired
    private PersonalService personalService;

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Override
    public List<Competition> competitionList(){

        return competitionRepository.findAll();
    }
    @Override
    public void createCompetition(Competition competition){
        amqpTemplate.convertAndSend("CreateCompetition", competition);
    }
    @Override
    public Competition OneCompetition(Integer id) {
        return competitionRepository.findById(id).orElseThrow(() -> new NotFoundException("competition", id));
    }

    @Override
    public void replaceCompetition(Competition newCompetition, Integer id) {
        newCompetition.setId(id);
        amqpTemplate.convertAndSend("ReplaceCompetition", newCompetition);

    }
    @Override
    public void deleteCompetition(Integer id) {
        competitionRepository.deleteById(id);

    }
}
