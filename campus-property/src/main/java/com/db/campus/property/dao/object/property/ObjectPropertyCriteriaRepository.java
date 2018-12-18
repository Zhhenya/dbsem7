package com.db.campus.property.dao.object.property;

import com.db.campus.property.dto.ObjectPropertyFilterDto;
import com.db.campus.property.entity.ObjectPropertyEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class ObjectPropertyCriteriaRepository {

    @PersistenceContext
    private EntityManager entityManager;
    private final ObjectPropertyFilterResolver objectPropertyFilterResolver;

    @Autowired
    public ObjectPropertyCriteriaRepository(ObjectPropertyFilterResolver objectPropertyFilterResolver) {
        this.objectPropertyFilterResolver = objectPropertyFilterResolver;
    }

    public List<ObjectPropertyEntity> findFiltered(ObjectPropertyFilterDto objectPropertyFilterDto) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ObjectPropertyEntity> query = builder.createQuery(ObjectPropertyEntity.class);
        Root<ObjectPropertyEntity> entityRoot = query.from(ObjectPropertyEntity.class);
        query.where(objectPropertyFilterResolver.resolve(objectPropertyFilterDto, builder, entityRoot)
                                                .toArray(new Predicate[0]));
        return entityManager.createQuery(query).getResultList();
    }

}
