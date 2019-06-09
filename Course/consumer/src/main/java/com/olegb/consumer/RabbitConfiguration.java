package com.olegb.consumer;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.logging.Logger;

@Configuration
public class RabbitConfiguration {
    Logger logger = Logger.getLogger(String.valueOf(RabbitConfiguration.class));

    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory =
                new CachingConnectionFactory("localhost");
        return connectionFactory;
    }

    @Bean
    public AmqpAdmin amqpAdmin() {
        RabbitAdmin rabbitAdmin = new RabbitAdmin(connectionFactory());
        return rabbitAdmin;
    }

    @Bean
    public RabbitTemplate rabbitTemplate() {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory());
        rabbitTemplate.setMessageConverter(ProducerJackson2JsonMessageConverter());
        return rabbitTemplate;
    }

    @Bean
    public Queue CreateStudentQueue() {
        return new Queue("CreateStudent");
    }

    @Bean
    public Queue GetOneStudentQueue() {
        return new Queue("GetOneStudent");
    }

    @Bean
    public Queue RemoveStudentQueue() {
        return new Queue("RemoveStudent");
    }

    @Bean
    public Queue GetStudentsQueue() {
        return new Queue("GetStudents");
    }

    @Bean
    public Queue UpdateStudentQueue() {
        return new Queue("UpdateStudent");
    }

    @Bean
    public Queue CreateCoachQueue() {
        return new Queue("CreateCoach");
    }

    @Bean
    public Queue GetOneCoachQueue() {
        return new Queue("GetOneCoach");
    }

    @Bean
    public Queue RemoveCoachQueue() {
        return new Queue("RemoveCoach");
    }

    @Bean
    public Queue GetCoachesQueue() {
        return new Queue("GetCoaches");
    }
    @Bean
    public Queue UpdateCoachQueue() {
        return new Queue("UpdateCoach");
    }

    @Bean
    public Queue CreateArtQueue() {
        return new Queue("CreateArt");
    }

    @Bean
    public Queue GetOneArtQueue() {
        return new Queue("GetOneArt");
    }

    @Bean
    public Queue RemoveArtQueue() {
        return new Queue("RemoveArt");
    }

    @Bean
    public Queue GetArtsQueue() {
        return new Queue("GetArts");
    }

    @Bean
    public Queue UpdateStudentArt() {
        return new Queue("UpdateArt");
    }
    @Bean
    public Queue CreateCompQueue() {
        return new Queue("CreateCompetition");
    }

    @Bean
    public Queue UpdateCompQueue() {
        return new Queue("ReplaceCompetition");
    }

    @Bean
    public Jackson2JsonMessageConverter ProducerJackson2JsonMessageConverter(){
        return new Jackson2JsonMessageConverter();
    }

}
