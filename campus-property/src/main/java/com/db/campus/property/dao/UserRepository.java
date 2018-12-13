package com.db.campus.property.dao;

import com.db.campus.property.entity.UserAccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserAccountEntity, Integer> {

    Optional<UserAccountEntity> findByLogin(String login);

}
