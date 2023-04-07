package com.example.homework13.model;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class TimeZone {

    private static final List<String> TIME_ZONES = Arrays.asList("UTC", "CET", "EST", "GMT", "EAT");

    public String getTime(String timeZone) {
        if (!TIME_ZONES.contains(timeZone)) {
            return "Invalid time zone";
        }

        LocalDateTime now = LocalDateTime.now(ZoneId.of(timeZone));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String formattedNow = now.format(formatter);
        return formattedNow;
    }
}
