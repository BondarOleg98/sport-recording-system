package com.olegb.functionalService.Controller;

import com.olegb.functionalService.Model.PersonalArea;
import com.olegb.functionalService.Model.Schedule;
import com.olegb.functionalService.Service.PersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/person")
public class PersonalController {

    @Autowired
    private PersonalService personalService;

    @PostMapping("/create")
    public PersonalArea createPerson(@RequestBody @Valid  PersonalArea personalArea){
        return personalService.createPersonal(personalArea);
    }

    @GetMapping
    public List<PersonalArea> ListPerson(){
        return personalService.personalAreaList();
    }

    @PostMapping("/confirm/{id}")
    public void confirm(String username, @PathVariable UUID id){
        personalService.confirm(username,id);
    }
    @PostMapping("/reject/{id}")
    public void reject(String username, @PathVariable UUID id){
        personalService.reject(username,id);
    }
}
