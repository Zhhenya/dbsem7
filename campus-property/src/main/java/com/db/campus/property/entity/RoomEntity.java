package com.db.campus.property.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "room", schema = "dbuniver", catalog = "")
public class RoomEntity {
    private long rNumber;
    private long rFloor;
    private long pkRoom;
    private long pkBuilding;
    private Collection<ObjectPropertyEntity> objectPropertiesByPkRoom;
    private BuildingEntity buildingByPkBuilding;

    @Basic
    @Column(name = "R_Number", nullable = false)
    public long getrNumber() {
        return rNumber;
    }

    public void setrNumber(long rNumber) {
        this.rNumber = rNumber;
    }

    @Basic
    @Column(name = "R_Floor", nullable = false)
    public long getrFloor() {
        return rFloor;
    }

    public void setrFloor(long rFloor) {
        this.rFloor = rFloor;
    }

    @Id
    @Column(name = "PK_Room", nullable = false)
    public long getPkRoom() {
        return pkRoom;
    }

    public void setPkRoom(long pkRoom) {
        this.pkRoom = pkRoom;
    }

    @Basic
    @Column(name = "PK_Building", nullable = false)
    public long getPkBuilding() {
        return pkBuilding;
    }

    public void setPkBuilding(long pkBuilding) {
        this.pkBuilding = pkBuilding;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoomEntity that = (RoomEntity) o;
        return rNumber == that.rNumber &&
               rFloor == that.rFloor &&
               pkRoom == that.pkRoom &&
               pkBuilding == that.pkBuilding;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rNumber, rFloor, pkRoom, pkBuilding);
    }

    @OneToMany(mappedBy = "roomByPkRoom")
    public Collection<ObjectPropertyEntity> getObjectPropertiesByPkRoom() {
        return objectPropertiesByPkRoom;
    }

    public void setObjectPropertiesByPkRoom(Collection<ObjectPropertyEntity> objectPropertiesByPkRoom) {
        this.objectPropertiesByPkRoom = objectPropertiesByPkRoom;
    }

    @ManyToOne
    @JoinColumn(name = "PK_Building", referencedColumnName = "PK_Building", nullable = false)
    public BuildingEntity getBuildingByPkBuilding() {
        return buildingByPkBuilding;
    }

    public void setBuildingByPkBuilding(BuildingEntity buildingByPkBuilding) {
        this.buildingByPkBuilding = buildingByPkBuilding;
    }
}
