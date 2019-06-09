package com.olegb.additionalService.Service;

import com.olegb.additionalService.Model.PersonalArea;
import com.olegb.additionalService.Repository.PersonalRepository;
import com.olegb.additionalService.Service.Contract.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PersonalService implements IPersonService {

    @Autowired
    private PersonalRepository personalRepository;

    @Override
    public PersonalArea createPersonal(PersonalArea personalArea){
        PersonalArea personFromDb =  personalRepository.findByName(personalArea.getName());
        if(personFromDb==null){
            UUID uuid = UUID.randomUUID();
            personalArea.setId(uuid);
            return personalRepository.save(personalArea);
        }
        personFromDb.setCompetitions(personalArea.getCompetitions());
        personFromDb.setName(personalArea.getName());
        return personalRepository.save(personFromDb);
    }

    @Override
    public List<PersonalArea> personalAreaList(){
        return personalRepository.findAll();
    }


}
