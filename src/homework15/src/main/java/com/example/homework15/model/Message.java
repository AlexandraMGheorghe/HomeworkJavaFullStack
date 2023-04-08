package com.example.homework15.model;

import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class Message {
     private String sender;
     private String receiver;
     private String text;
     private Boolean seen;
     private OffsetDateTime sentDate;
}
