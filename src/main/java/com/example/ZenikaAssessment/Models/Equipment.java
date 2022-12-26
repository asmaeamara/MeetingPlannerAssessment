package com.zenikaassasement.assasement.Models;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "Equipments")
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long equipmentId;

    @Column(name = "Designation")
    private String Designation;

    @ManyToMany(mappedBy = "linkedEquipments")
    Set<Room> rooms;

    public Equipment() {

    }

    public Equipment(String designation) {
        Designation = designation;
    }

    public long getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(long equipmentId) {
        this.equipmentId = equipmentId;
    }

    public String getDesignation() {
        return Designation;
    }

    public void setDesignation(String designation) {
        Designation = designation;
    }
}
