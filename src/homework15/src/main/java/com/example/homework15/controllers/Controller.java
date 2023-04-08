package com.example.homework15.controllers;

import com.example.homework15.model.Course;
import com.example.homework15.model.Message;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;

@RestController
public class Controller {
    ObjectMapper objectMapper = new ObjectMapper();

    @GetMapping(value = "/jsonfile")
    public String readJson (){
        try {
            Course course = objectMapper.readValue(new File("src/main/java/com/example/homework15/Json_homework.json"), Course.class);
            return course.toString();
        } catch (IOException e) {
            return e.toString();
        }
    }

    @GetMapping(value = "/jsonarray")
    public String parseJsonArray() {
        try {
            Course[] courses = objectMapper.readValue(new File("src/main/java/com/example/homework15/Json_array_homework.json"), Course[].class);
            String result = "";
            for (Course course : courses) {
                result += course.toString();
                result += "\n";
            }
            return result;
        } catch (IOException e) {
            return e.toString();
        }
    }


    @PostMapping (value = "/messages")
    public ResponseEntity<Message> createMessage(@RequestBody Message message,
                                                 @RequestHeader("authentication") String authentication) {
        if ("devmind-api-key".equals(authentication)) {
            return new ResponseEntity<>(message, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
}




