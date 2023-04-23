package com.example.homework16.service;

import com.example.homework16.model.User;
import com.example.homework16.model.UserLogged;
import com.example.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServices {

   private static UserRepository userRepository;
   public User register (@NotNull User user){
       return userRepository.add(user);
   }

   public Optional<User> login (@NotNull UserLogged user){
       return userRepository.findUserByEmailAndPassword(user);
   }

   public boolean checkUser(@NotNull UserLogged userLogged){
       return userRepository.updateLoggedUsers(userLogged);
   }

   public Optional<UserLogged> logout (String email){
       return userRepository.remove(email);
   }
}
