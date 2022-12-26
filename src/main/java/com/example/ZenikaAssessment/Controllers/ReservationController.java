package com.zenikaassasement.assasement.Controllers;

import com.zenikaassasement.assasement.Helpers.ReservationModel;
import com.zenikaassasement.assasement.Models.Reservation;
import com.zenikaassasement.assasement.Services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/reservation")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @PostMapping("/add")
    public ResponseEntity<String> reserveRoom(@RequestBody ReservationModel model) {
        try {
            reservationService.reserveRoom(model);
            return new ResponseEntity<>("Reservation created for Room " + model.getRoomName() + " from " + model.getStartDate() + " and until " + model.getEndDate(), HttpStatus.CREATED);
        }
        catch(Exception ex) {
            ex.printStackTrace();
            return  new ResponseEntity<>("Reservation failed", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
