package com.zenikaassasement.assasement.Services;

import com.zenikaassasement.assasement.Models.Room;
import com.zenikaassasement.assasement.Repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    public Room addRoom(Room room) {
        return roomRepository.save(room);
    }

    public Optional<Room> getRoom(long id) {
        return roomRepository.findById(id);
    }

    public List<Room> getAllRooms(long id) {
        return roomRepository.findAll();
    }

    public void deleteRoom(long id) {
        roomRepository.deleteById(id);
    }
}
