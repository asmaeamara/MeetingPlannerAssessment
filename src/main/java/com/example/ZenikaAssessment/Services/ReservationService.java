package com.example.ZenikaAssessment.Services;

import com.zenikaassasement.assasement.Helpers.ReservationModel;
import com.zenikaassasement.assasement.Models.Reservation;
import com.zenikaassasement.assasement.Models.Room;
import com.zenikaassasement.assasement.Repository.ReservationRepository;
import com.zenikaassasement.assasement.Repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private RoomRepository roomRepository;

    public void reserveRoom(ReservationModel model) {
        boolean canBeReserved = isRoomAvailable(model);
        if(canBeReserved) {
            Room reservedRoom = roomRepository.findByRoomName(model.getRoomName());
            Reservation newReservation = new Reservation(model.getStartDate(), model.getEndDate(), reservedRoom);
            reservationRepository.save(newReservation);
        }
        else {
            throw new NullPointerException("Room cannot be reserved, please pick another timeslot");
        }
    }
    public boolean isRoomAvailable(ReservationModel model) {
        Room room = roomRepository.findByRoomName(model.getRoomName());

        if(room == null) throw new NullPointerException("No room to reserve");

        List<Reservation> reservations = reservationRepository.findByRoomId(room.getRoomId());
        for(Reservation reservation : reservations) {
            if(!reservationOverlaps(model.getStartDate(),
                    model.getEndDate(),
                    reservation.getStartTime(),
                    reservation.getEndTime())
            ) {
                return false;
            }
        }
        return true;
    }

    public boolean reservationOverlaps(Date start1, Date end1, Date start2, Date end2) {
        if(end1.after(start1) && end2.after(start2)) {
            if(end1.before(start2)) {
                return true;
            }
            if(start1.after(end2)) {
                return true;
            }
            return false;
        }
        throw new IllegalArgumentException("Date arguments are not valid");
    }
}
