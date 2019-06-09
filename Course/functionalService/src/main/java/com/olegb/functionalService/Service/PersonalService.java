package com.olegb.functionalService.Service;
import com.olegb.functionalService.Model.PersonalArea;
import com.olegb.functionalService.Model.Schedule;
import com.olegb.functionalService.Repository.PersonalRepository;
import com.olegb.functionalService.Service.Contract.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

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
        personFromDb.setFlag(personalArea.getFlag());
        personFromDb.setSchedules(personalArea.getSchedules());
        personFromDb.setName(personalArea.getName());
        return personalRepository.save(personFromDb);
    }

    @Override
    public void confirm(String username, UUID id){
        PersonalArea personFromDb =  personalRepository.findByName(username);
        if(personFromDb!=null)
            if(personFromDb.getId().equals(id))
                personFromDb.setFlag(1);
        personalRepository.save(personFromDb);
    }
    @Override
    public void reject(String username, UUID id){
        PersonalArea personFromDb =  personalRepository.findByName(username);
        if(personFromDb!=null)
            if(personFromDb.getId().equals(id))
                personFromDb.setFlag(2);
        personalRepository.save(personFromDb);
    }

    @Override
    public List<PersonalArea> personalAreaList(){
        return personalRepository.findAll();
    }


}
