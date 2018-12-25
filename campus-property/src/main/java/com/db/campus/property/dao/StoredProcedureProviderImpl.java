package com.db.campus.property.dao;

import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

@Service
public class StoredProcedureProviderImpl implements StoredProcedureProvider {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void callInitInventory() {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("initInventarisation");
        query.execute();
    }
}
