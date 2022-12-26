package com.zenikaassasement.assasement.Helpers;

import java.util.Date;

public class ReservationModel {

    private String roomName;
    private Date startDate;
    private Date endDate;

    public ReservationModel(String roomName, Date startDate, Date endDate) {
        this.roomName = roomName;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
