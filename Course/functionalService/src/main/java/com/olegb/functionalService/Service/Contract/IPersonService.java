package com.olegb.functionalService.Service.Contract;
import com.olegb.functionalService.Model.PersonalArea;

import java.util.List;
import java.util.UUID;

public interface IPersonService {
    List<PersonalArea> personalAreaList();
    PersonalArea createPersonal(PersonalArea personalArea);
    void confirm(String username, UUID id);
    void reject(String username, UUID id);
}
