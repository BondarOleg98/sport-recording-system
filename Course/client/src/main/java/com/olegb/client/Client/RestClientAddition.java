package com.olegb.client.Client;

import com.olegb.client.Model.Competition;
import com.olegb.client.Model.PersonalArea;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;

@FeignClient("additionService")
public interface RestClientAddition {
    @GetMapping("/competition")
    List<Competition> competitionList();

    @PostMapping("/competition/create")
    void createCompetition(Competition competition);

    @GetMapping("/competition/{id}")
    Competition OneCompetition(@PathVariable Integer id);

    @PostMapping("/competition/update/{id}")
    void replaceCompetition( Competition newCompetition, @PathVariable Integer id);

    @PostMapping("/competition/delete/{id}")
    void deleteCompetition(@PathVariable Integer id);

    @PostMapping("/personal/create")
    PersonalArea createPersonal(PersonalArea personalArea);

    @GetMapping("/personal")
    List<PersonalArea> ListPersonal();

}
