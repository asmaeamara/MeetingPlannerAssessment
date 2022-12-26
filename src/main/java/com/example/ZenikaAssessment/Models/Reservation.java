package com.zenikaassasement.assasement.Models;

import jakarta.persistence.*;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;

@Entity
@Table(name = "Reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long reservationId;

    @Column(name = "StartTime")
    private Date startTime;

    @Column(name = "EndTime")
    private  Date endTime;

    public Reservation() {

    }

    public Reservation(Date startTime, Date endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Reservation(Date startTime, Date endTime, Room room) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.room = room;
    }

    public long getReservationId() {
        return reservationId;
    }

    public void setReservationId(long reservationId) {
        this.reservationId = reservationId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;

}
