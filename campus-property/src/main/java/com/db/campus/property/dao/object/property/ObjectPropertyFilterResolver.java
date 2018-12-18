package com.db.campus.property.dao.object.property;

import com.db.campus.property.dto.ObjectPropertyFilterDto;
import com.db.campus.property.entity.ObjectPropertyEntity;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public interface ObjectPropertyFilterResolver {

    List<Predicate> resolve(ObjectPropertyFilterDto filterDto,
                            CriteriaBuilder criteriaBuilder,
                            Root<ObjectPropertyEntity> propertyEntity);

}
