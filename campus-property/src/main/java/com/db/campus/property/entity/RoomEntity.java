package com.db.campus.property.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "room", schema = "dbuniver")
public class RoomEntity {
    private long number;
    private long floor;
    private long id;
    private Collection<ObjectPropertyEntity> objectProperties;
    private BuildingEntity building;

    @Basic
    @Column(name = "R_Number", nullable = false)
    public long getNumber() {
        return number;
    }

    public void setNumber(long rNumber) {
        this.number = rNumber;
    }

    @Basic
    @Column(name = "R_Floor", nullable = false)
    public long getFloor() {
        return floor;
    }

    public void setFloor(long rFloor) {
        this.floor = rFloor;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_Room", nullable = false, updatable = false)
    public long getId() {
        return id;
    }

    public void setId(long pkRoom) {
        this.id = pkRoom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoomEntity that = (RoomEntity) o;
        return number == that.number &&
               floor == that.floor &&
               id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, floor, id);
    }

    @OneToMany(mappedBy = "room")
    public Collection<ObjectPropertyEntity> getObjectProperties() {
        return objectProperties;
    }

    public void setObjectProperties(Collection<ObjectPropertyEntity> objectProperties) {
        this.objectProperties = objectProperties;
    }

    @ManyToOne
    @JoinColumn(name = "PK_Building", referencedColumnName = "PK_Building", nullable = false)
    public BuildingEntity getBuilding() {
        return building;
    }

    public void setBuilding(BuildingEntity building) {
        this.building = building;
    }
}
