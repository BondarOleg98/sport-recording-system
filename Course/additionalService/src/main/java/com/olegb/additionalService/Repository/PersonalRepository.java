package com.olegb.additionalService.Repository;

import com.olegb.additionalService.Model.PersonalArea;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PersonalRepository extends JpaRepository<PersonalArea, UUID> {
    PersonalArea findByName(String name);
}
