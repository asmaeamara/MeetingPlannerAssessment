package com.zenikaassasement.assasement.Repository;

import com.zenikaassasement.assasement.Models.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    @Query("SELECT r FROM Reservation r WHERE r.room.roomId= ?1")
    List<Reservation> findByRoomId(long id);
}
