package com.db.campus.property.converter;


import com.db.campus.property.dto.UserAccountDto;
import com.db.campus.property.entity.UserAccountEntity;
import org.springframework.stereotype.Service;

@Service
public class UserAccountConverter extends CampusPropertyConverter<UserAccountEntity, UserAccountDto>{


    @Override
    public UserAccountDto convert(UserAccountEntity userAccountEntity) {
        UserAccountDto userAccountDto = new UserAccountDto();
        userAccountDto.setId(Long.valueOf(userAccountEntity.getId()));
        userAccountDto.setLogin(userAccountEntity.getLogin());
        userAccountDto.setPassword(userAccountEntity.getPassword());
        userAccountDto.setRole(userAccountEntity.getRole().getName());
        return userAccountDto;
    }
}
