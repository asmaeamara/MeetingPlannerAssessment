package com.zenikaassasement.assasement.Models;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;


@Entity
@Table(name = "Rooms")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long roomId;

    @Column(name = "roomName")
    private String roomName;

    @Column(name = "roomCapacity")
    private int roomCapacity;

    @OneToMany(mappedBy = "room", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Reservation> reservations;

    @ManyToMany
    @JoinTable(
            name = "equipments_like",
            joinColumns = @JoinColumn(name = "room_id"),
            inverseJoinColumns = @JoinColumn(name = "equipment_id")
    )
    Set<Equipment> linkedEquipments;

    public Room() {
    }

    public Room(String roomName, int roomCapacity) {
        this.roomName = roomName;
        this.roomCapacity = roomCapacity;
    }

    public Room(String roomName, int roomCapacity, Set<Equipment> linkedEquipments) {
        this.roomName = roomName;
        this.roomCapacity = roomCapacity;
        this.linkedEquipments = linkedEquipments;
    }

    public long getRoomId() {
        return roomId;
    }

    public void setRoomId(long roomId) {
        this.roomId = roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public int getRoomCapacity() {
        return roomCapacity;
    }

    public void setRoomCapacity(int roomCapacity) {
        this.roomCapacity = roomCapacity;
    }

    @Override
    public String toString() {
        return "Room : " + roomId + ", name : " + roomName + ", capacity : " + roomCapacity;
    }

}
