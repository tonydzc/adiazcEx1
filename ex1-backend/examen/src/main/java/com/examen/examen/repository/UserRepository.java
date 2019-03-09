package com.examen.examen.repository;

import com.examen.examen.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository< User, Long> {
    User findByNickname(String name);
}
