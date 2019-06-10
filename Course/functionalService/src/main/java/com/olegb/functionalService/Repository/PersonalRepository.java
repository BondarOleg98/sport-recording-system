package com.olegb.functionalService.Repository;
import com.olegb.functionalService.Model.PersonalArea;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PersonalRepository extends JpaRepository<PersonalArea, UUID> {
    PersonalArea findByName(String name);
}
