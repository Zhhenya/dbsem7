package com.db.campus.property.converter;

import com.db.campus.property.dto.RoleDto;
import com.db.campus.property.entity.RoleEntity;
import org.springframework.stereotype.Service;

@Service
public class RoleConverter  extends CampusPropertyConverter<RoleEntity, RoleDto> {

    @Override
    public RoleDto convert(RoleEntity roleEntity) {
        RoleDto roleDto = new RoleDto();
        roleDto.setId(roleEntity.getId());
        roleDto.setName(roleEntity.getName());
        return roleDto;
    }
}
