package com.zenikaassasement.assasement.Repository;

import com.zenikaassasement.assasement.Models.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface RoomRepository extends JpaRepository<Room, Long> {
    Room findByRoomName(String roomName);
}
