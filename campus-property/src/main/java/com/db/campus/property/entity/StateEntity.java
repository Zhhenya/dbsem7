package com.db.campus.property.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "state", schema = "dbuniver")
public class StateEntity {
    private String name;
    private long id;
    private Collection<ObjectPropertyEntity> objectProperties;

    @Basic
    @Column(name = "S_Name", nullable = false, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_State", nullable = false, updatable = false)
    public long getId() {
        return id;
    }

    public void setId(long pkState) {
        this.id = pkState;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StateEntity that = (StateEntity) o;
        return id == that.id &&
               Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }

    @OneToMany(mappedBy = "state")
    public Collection<ObjectPropertyEntity> getObjectProperties() {
        return objectProperties;
    }

    public void setObjectProperties(Collection<ObjectPropertyEntity> objectProperties) {
        this.objectProperties = objectProperties;
    }
}
