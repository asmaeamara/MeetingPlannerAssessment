package com.zenikaassasement.assasement.Controllers;

import com.zenikaassasement.assasement.Models.Room;
import com.zenikaassasement.assasement.Repository.RoomRepository;
import com.zenikaassasement.assasement.Services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/room")
public class RoomController {

    @Autowired
    RoomRepository roomRepository;
    @Autowired
    RoomService roomService;

    @GetMapping("/all_rooms")
    public ResponseEntity<List<Room>> getAllRooms() {
        try {
            List<Room> rooms = new ArrayList<>();
            rooms = roomRepository.findAll();

            if(rooms.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(rooms, HttpStatus.OK);
        }
        catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/add-room")
    public ResponseEntity<Room> createRoom(@RequestBody Room room) {
        try {
            Room newRoom = roomService.addRoom(room);
            return new ResponseEntity<>(newRoom, HttpStatus.CREATED);
        }
        catch(Exception ex) {
            return  new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
