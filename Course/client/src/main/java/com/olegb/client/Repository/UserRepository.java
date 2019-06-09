package com.olegb.client.Repository;

import com.olegb.client.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByUsername(String username);
}
