package com.example.ZenikaAssessment;

import com.zenikaassasement.assasement.Models.Room;
import com.zenikaassasement.assasement.Services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ZenikaAssessmentApplication {

    @Autowired
    private RoomService roomService;

    public static void main(String[] args) {
        SpringApplication.run(ZenikaAssessmentApplication.class, args);
    }
}
