package com.db.campus.property.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "state", schema = "dbuniver", catalog = "")
public class StateEntity {
    private String sName;
    private long pkState;
    private Collection<ObjectPropertyEntity> objectPropertiesByPkState;

    @Basic
    @Column(name = "S_Name", nullable = false, length = 50)
    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    @Id
    @Column(name = "PK_State", nullable = false)
    public long getPkState() {
        return pkState;
    }

    public void setPkState(long pkState) {
        this.pkState = pkState;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StateEntity that = (StateEntity) o;
        return pkState == that.pkState &&
               Objects.equals(sName, that.sName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sName, pkState);
    }

    @OneToMany(mappedBy = "stateByPkState")
    public Collection<ObjectPropertyEntity> getObjectPropertiesByPkState() {
        return objectPropertiesByPkState;
    }

    public void setObjectPropertiesByPkState(Collection<ObjectPropertyEntity> objectPropertiesByPkState) {
        this.objectPropertiesByPkState = objectPropertiesByPkState;
    }
}
