package com.example.homework16.controller;

import com.example.homework16.model.User;
import com.example.homework16.model.UserLogged;
import com.example.homework16.service.UserServices;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class UserController {

    UserServices userServices;

    @PostMapping("/register")
    public ResponseEntity<User> handleRegister(@Valid @RequestBody User user) {
        return ResponseEntity.ok(userServices.register(user));
    }

    @PostMapping("/login")
    public ResponseEntity<User> handleLogin(@RequestBody UserLogged loggedUser) {
        Optional<User> optionalUser = userServices.login(loggedUser);
        if (optionalUser.isPresent()){
            User user = optionalUser.get();
            if (userServices.checkUser(loggedUser)){
                return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
            }else{
                return ResponseEntity.ok(user);
            }
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/logout/{email}")
    public ResponseEntity<String> handleLogut (@PathVariable String email){
        Optional<UserLogged> optionalUserLogged = userServices.logout(email);
        if (optionalUserLogged.isPresent()){
            return ResponseEntity.ok("User " + email+ " logged out! ");
        }else{
            return new ResponseEntity<>("User " + email + " is not logged in", HttpStatus.FORBIDDEN);
        }
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        return errors;

    }
}

