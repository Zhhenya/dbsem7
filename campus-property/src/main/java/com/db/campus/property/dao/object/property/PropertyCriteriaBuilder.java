package com.db.campus.property.dao.object.property;

import com.db.campus.property.entity.AccountantEntity;
import com.db.campus.property.entity.BuildingEntity;
import com.db.campus.property.entity.EconomicOfficerEntity;
import com.db.campus.property.entity.StateEntity;

import javax.persistence.criteria.Predicate;
import java.util.Date;

public interface PropertyCriteriaBuilder {

    Predicate buildCaptionCriteria(String caption);
    Predicate buildPropertyNumberCriteria(String numberGreater, String numberLess);
    Predicate buildMakerCriteria(String maker);
    Predicate buildDateCriteria(Date dateLater, Date dateEarlier);
    Predicate buildCostCriteria(Double costGreater, Double costLess);
    Predicate buildRoomCriteria(Long roomNumber);
    Predicate buildBuildingCriteria(BuildingEntity buildingEntity);
    Predicate buildStateCriteria(StateEntity stateEntity);
    Predicate buildOfficerCriteria(EconomicOfficerEntity officerEntity);
    Predicate buildAccountantCriteria(AccountantEntity accountantEntity);

}
