package com.user.service.user.Repository;

import com.user.service.user.Model.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface UserRepository extends JpaRepository<UserData, Integer> {
}
