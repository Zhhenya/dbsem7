package com.db.campus.property.dao;

import com.db.campus.property.entity.UserAccountEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserAccountEntity, Integer> {

    UserAccountEntity findByLogin(String login);

}
