package com.olegb.service.Repository;

import com.olegb.service.Model.ArtStyle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ArtRepository extends JpaRepository<ArtStyle, UUID> {

}
