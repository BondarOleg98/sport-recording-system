package com.olegb.client.Client;

import com.olegb.client.Model.PersonalArea;
import com.olegb.client.Model.Schedule;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;

@FeignClient("functionalService")
public interface RestClientFunctional {

    @PostMapping("/person/create")
    PersonalArea createPerson(PersonalArea personalArea);

    @GetMapping("/person")
    List<PersonalArea> ListPerson();

    @PostMapping("/person/confirm/{id}")
    void confirm(@RequestParam String username,@PathVariable UUID id);

    @PostMapping("/person/reject/{id}")
    void reject(@RequestParam String username, @PathVariable UUID id);

}
