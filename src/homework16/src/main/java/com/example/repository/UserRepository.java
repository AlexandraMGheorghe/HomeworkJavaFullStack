package com.example.repository;

import com.example.homework16.exception.ExeptionRegistedUser;
import com.example.homework16.exception.MismatchedPasswordException;
import com.example.homework16.model.User;
import com.example.homework16.model.UserLogged;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class UserRepository {
    private static Map<String, User> users = new HashMap<>();
    private static Map<String, UserLogged> loggedUsers = new HashMap<>();

      public User add(@NotNull User user) {
        if (!users.containsKey(user.getEmail())) {
            users.put(user.getEmail(), user);
            return user;
        }

        throw new ExeptionRegistedUser("User " + user + " already exists!");
    }

    public Optional <User> findUserByEmailAndPassword (@NotNull UserLogged user){
        if(!users.containsKey(user.getEmail())){
            throw new IllegalArgumentException("User" + user.getEmail() + "doesn't exist");
        }

        User registeredUser = users.get(user.getEmail());
        if(registeredUser.getPassword().equals(user.getPassword())){
            return Optional.of(registeredUser);
        }

        throw new MismatchedPasswordException("Passwords for user" + user.getEmail() + "are not matching!");
    }

    public boolean updateLoggedUsers (@NotNull UserLogged user){
        if (!loggedUsers.containsKey((user.getEmail()))){
            loggedUsers.put(user.getEmail(), user);
            return false;
        }
        return true;
    }

    public Optional<UserLogged> remove (String email){
        UserLogged registeredUser = loggedUsers.get(email);
        if (registeredUser != null){
            loggedUsers.remove(email);
            return Optional.of(registeredUser);
        }
        return Optional.empty();
    }
}
