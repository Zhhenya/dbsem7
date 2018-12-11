package com.db.campus.property.converter;

import com.db.campus.property.dto.ObjectPropertyDto;
import com.db.campus.property.entity.ObjectPropertyEntity;
import com.db.campus.property.entity.StateEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ObjectPropertyConverter extends CampusPropertyConverter<ObjectPropertyEntity, ObjectPropertyDto> {

    private final AccountantConverter accountantConverter;
    private final EconomicOfficerConverter economicOfficerConverter;
    private final RoomConverter roomConverter;

    @Autowired
    public ObjectPropertyConverter(AccountantConverter accountantConverter,
                                   EconomicOfficerConverter economicOfficerConverter,
                                   RoomConverter roomConverter) {
        this.accountantConverter = accountantConverter;
        this.economicOfficerConverter = economicOfficerConverter;
        this.roomConverter = roomConverter;
    }

    @Override
    public ObjectPropertyDto convert(ObjectPropertyEntity propertyEntity) {
        ObjectPropertyDto propertyDto = new ObjectPropertyDto();
        propertyDto.setId(propertyEntity.getId());
        propertyDto.setPropertyNumber(propertyEntity.getPropertyNumber());
        propertyDto.setCaption(propertyEntity.getCaption());
        propertyDto.setCost(String.format("%.2f", propertyEntity.getCost()));
        propertyDto.setMaker(propertyEntity.getMaker());
        propertyDto.setDate(propertyEntity.getDate().toString());
        propertyDto.setAccountant(accountantConverter.convert(propertyEntity.getAccountant()));
        propertyDto.setEconomicOfficer(economicOfficerConverter.convert(propertyEntity.getEconomicOfficer()));
        propertyDto.setRoom(roomConverter.convert(propertyEntity.getRoom()));
        propertyDto.setState(defaultConvert(propertyEntity.getState(), StateEntity::getName));
        return propertyDto;
    }
}
