package com.olegb.additionalService.Controller;

import com.olegb.additionalService.Model.PersonalArea;
import com.olegb.additionalService.Service.PersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/personal")
public class PersonalController {

    @Autowired
    private PersonalService personalService;

    @PostMapping("create")
    PersonalArea createPersonal(@RequestBody @Valid  PersonalArea personalArea){
        return personalService.createPersonal(personalArea);
    }

    @GetMapping
    List<PersonalArea> ListPersonal(){
        return personalService.personalAreaList();
    }
}
