package com.olegb.service.Repository;

import com.olegb.service.Model.Log;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogRepository extends JpaRepository<Log,Integer> {
}
