package com.example.homework13.controller;

import com.example.homework13.model.HarryPoterService;
import com.example.homework13.model.MathRequest;
import com.example.homework13.model.MathResult;
import com.example.homework13.model.TimeZone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

import com.github.javafaker.Faker;

@RestController
public class Controller {

    @Autowired
    TimeZone timeZone;

    @Autowired
    HarryPoterService harryPoterService;


    @GetMapping(value = "/time")
    public String getCurrentTime(@RequestParam(name = "timeZone", defaultValue = "UTC") String timeZones) {
        return timeZone.getTime(timeZones);
    }

    @GetMapping("/harry-potter")
    public String getHarryPotterCharacterName() {
        return harryPoterService.getRandomCharacter();
    }

    @RequestMapping(value = "/math-service", method = RequestMethod.POST)
    public MathResult mathService (@RequestBody MathRequest mathRequest){
       return new MathResult(mathRequest.operation());
    }


}


