package com.db.campus.property.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "building", schema = "dbuniver", catalog = "")
public class BuildingEntity {
    private String address;
    private long pkBuilding;
    private Collection<RoomEntity> roomsByPkBuilding;

    @Basic
    @Column(name = "Address", nullable = false, length = 100)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Id
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
        BuildingEntity that = (BuildingEntity) o;
        return pkBuilding == that.pkBuilding &&
               Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address, pkBuilding);
    }

    @OneToMany(mappedBy = "buildingByPkBuilding")
    public Collection<RoomEntity> getRoomsByPkBuilding() {
        return roomsByPkBuilding;
    }

    public void setRoomsByPkBuilding(Collection<RoomEntity> roomsByPkBuilding) {
        this.roomsByPkBuilding = roomsByPkBuilding;
    }
}
