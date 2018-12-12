package com.db.campus.property.dao;

import com.db.campus.property.entity.UserAccountEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UserAccountEntity, Integer> {

    Optional<UserAccountEntity> findByLogin(String login);

}
