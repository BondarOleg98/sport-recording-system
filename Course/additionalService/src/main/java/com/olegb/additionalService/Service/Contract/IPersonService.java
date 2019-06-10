package com.olegb.additionalService.Service.Contract;

import com.olegb.additionalService.Model.PersonalArea;

import java.util.List;

public interface IPersonService {
    List<PersonalArea> personalAreaList();
    PersonalArea createPersonal(PersonalArea personalArea);
}
