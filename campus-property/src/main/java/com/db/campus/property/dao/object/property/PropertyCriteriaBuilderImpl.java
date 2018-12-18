package com.db.campus.property.dao.object.property;

import com.db.campus.property.entity.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Date;

public class PropertyCriteriaBuilderImpl implements PropertyCriteriaBuilder {

    private final CriteriaBuilder criteriaBuilder;
    private final Root<ObjectPropertyEntity> propertyEntity;

    public PropertyCriteriaBuilderImpl(CriteriaBuilder criteriaBuilder,
                                       Root<ObjectPropertyEntity> propertyEntity) {
        this.criteriaBuilder = criteriaBuilder;
        this.propertyEntity = propertyEntity;
    }

    @Override
    public Predicate buildCaptionCriteria(String caption) {
        return criteriaBuilder.like(propertyEntity.get("caption"), "%" + caption + "%");
    }

    @Override
    public Predicate buildPropertyNumberCriteria(String numberGreater,
                                                 String numberLess) {
        return criteriaBuilder.between(propertyEntity.get("propertyNumber"), numberGreater, numberLess);
    }

    @Override
    public Predicate buildMakerCriteria(String maker) {
        return criteriaBuilder.equal(propertyEntity.get("maker"), maker);
    }

    @Override
    public Predicate buildDateCriteria(Date dateLater, Date dateEarlier) {
        return criteriaBuilder.between(propertyEntity.get("date"), dateLater, dateEarlier);
    }

    @Override
    public Predicate buildCostCriteria(Double costGreater, Double costLess) {
        return criteriaBuilder.between(propertyEntity.get("cost"), costGreater, costLess);
    }

    @Override
    public Predicate buildRoomCriteria(RoomEntity roomEntity) {
        return criteriaBuilder.equal(propertyEntity.get("room"), roomEntity);
    }

    @Override
    public Predicate buildBuildingCriteria(BuildingEntity buildingEntity) {
        return criteriaBuilder.equal(propertyEntity.get("room").get("building"), buildingEntity);
    }

    @Override
    public Predicate buildStateCriteria(StateEntity stateEntity) {
        return criteriaBuilder.equal(propertyEntity.get("state"), stateEntity);
    }

    @Override
    public Predicate buildOfficerCriteria(EconomicOfficerEntity officerEntity) {
        return criteriaBuilder.equal(propertyEntity.get("economicOfficer"), officerEntity);
    }

    @Override
    public Predicate buildAccountantCriteria(AccountantEntity accountantEntity) {
        return criteriaBuilder.equal(propertyEntity.get("accountant"), accountantEntity);
    }
}
