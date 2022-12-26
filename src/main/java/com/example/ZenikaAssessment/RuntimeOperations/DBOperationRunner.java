package com.zenikaassasement.assasement.RuntimeOperations;

import com.zenikaassasement.assasement.Helpers.ReservationModel;
import com.zenikaassasement.assasement.Models.Equipment;
import com.zenikaassasement.assasement.Models.Reservation;
import com.zenikaassasement.assasement.Models.Room;
import com.zenikaassasement.assasement.Repository.EquipmentRepository;
import com.zenikaassasement.assasement.Repository.ReservationRepository;
import com.zenikaassasement.assasement.Repository.RoomRepository;
import com.zenikaassasement.assasement.Services.ReservationService;
import com.zenikaassasement.assasement.Services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class DBOperationRunner implements CommandLineRunner {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private RoomService roomService;
    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private EquipmentRepository equipmentRepository;

    @Override
    public void run(String... args) throws Exception {

        //Date start2 = new Date(2022, 12, 5, 15, 0, 0);
        //Date end2 = new Date(2022, 12, 5, 16, 0, 0);
        //Date start1 = new Date(2022, 12, 5, 14, 00, 0);
        //Date end1 = new Date(2022, 12, 5, 14, 30, 0);

        //System.out.println(reservationService.reservationOverlaps(start1, end1, start2, end2));
        //ReservationModel model = new ReservationModel("Room1", start1, end1);
        //System.out.println(reservationService.isRoomAvailable(model));
        //reservationService.reserveRoom(model);

        Equipment eq1 = new Equipment("Ecran");
        Equipment eq2 = new Equipment("Pieuvre");
        Equipment eq3 = new Equipment("Webcam");
        Equipment eq4 = new Equipment("Tableau");

        equipmentRepository.save(eq1);
        equipmentRepository.save(eq3);
        equipmentRepository.save(eq4);

        Set<Equipment> equipmentSet = new HashSet<>();
        equipmentSet.add(eq1);
        equipmentSet.add(eq3);
        equipmentSet.add(eq4);

        roomService.addRoom(new Room("E3001", 13, equipmentSet));
    }
}
