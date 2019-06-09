package com.olegb.consumer.Repository;

import com.olegb.consumer.Models.Competition;
import com.olegb.consumer.Models.Log;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@EnableRabbit
@Component
public class RabbitMqListener {
    Logger logger = Logger.getLogger(String.valueOf(RabbitMqListener.class));


    @Autowired
    private LogRepository logRepository;

    @Autowired
    private CompetitionRepository competitionRepository;


    @RabbitListener(queues = "GetOneStudent")
    public void processMessage1(Log log){
        logger.info("GettingMessage");
        logRepository.save(log);
    }
    @RabbitListener(queues = "GetStudents")
    public void processMessage2(Log log){
        logger.info("GettingMessage");
        logRepository.save(log);
    }
    @RabbitListener(queues = "CreateStudent")
    public void processMessage3(Log log){
        logger.info("CreatingMessage");
        logRepository.save(log);
    }
    @RabbitListener(queues = "RemoveStudent")
    public void processMessage4(Log log){
        logger.info("RemovingMessage");
        logRepository.save(log);
    }

    @RabbitListener(queues = "GetOneCoach")
    public void processMessage5(Log log){
        logger.info("GettingMessage");
        logRepository.save(log);
    }
    @RabbitListener(queues = "GetCoaches")
    public void processMessage6(Log log){
        logger.info("GettingMessage");
        logRepository.save(log);
    }
    @RabbitListener(queues = "CreateCoach")
    public void processMessage7(Log log){
        logger.info("CreatingMessage");
        logRepository.save(log);
    }
    @RabbitListener(queues = "RemoveCoach")
    public void processMessage8(Log log){
        logger.info("RemovingMessage");
        logRepository.save(log);
    }
    @RabbitListener(queues = "GetOneArt")
    public void processMessage9(Log log){
        logger.info("GettingMessage");
        logRepository.save(log);
    }
    @RabbitListener(queues = "GetArts")
    public void processMessage10(Log log){
        logger.info("GettingMessage");
        logRepository.save(log);
    }
    @RabbitListener(queues = "CreateArt")
    public void processMessage11(Log log){
        logger.info("CreatingMessage");
        logRepository.save(log);
    }
    @RabbitListener(queues = "RemoveArt")
    public void processMessage12(Log log){
        logger.info("RemovingMessage");
        logRepository.save(log);
    }
    @RabbitListener(queues = "UpdateStudent")
    public void processMessage13(Log log){
        logger.info("UpdateMessage");
        logRepository.save(log);
    }
    @RabbitListener(queues = "UpdateArt")
    public void processMessage14(Log log){
        logger.info("UpdateMessage");
        logRepository.save(log);
    }
    @RabbitListener(queues = "UpdateCoach")
    public void processMessage15(Log log){
        logger.info("UpdateMessage");
        logRepository.save(log);
    }

    @RabbitListener(queues = "CreateCompetition")
    public void processMessage18(Competition competition){
        competitionRepository.save(competition);
    }
    @RabbitListener(queues = "ReplaceCompetition")
    public void processMessage19(Competition newCompetition){
        competitionRepository.findById(newCompetition.getId())
                .map(competition -> {
                    competition.setName(newCompetition.getName());
                    competition.setCity(newCompetition.getCity());
                    competition.setCountry(newCompetition.getCountry());
                    competition.setT(newCompetition.getT());
                    return competitionRepository.save(competition);}
                );
    }
}
