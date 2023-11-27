package com.example.BoMoC.controller;

import com.example.BoMoC.dao.userdao.UserDao;
import com.example.BoMoC.dao.userdao.UserImplement;
import com.example.BoMoC.model.user.Account;
import com.example.BoMoC.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UsersController {
    private  UserDao userDao;
    @Autowired
    public UsersController(UserImplement userDao) {
        this.userDao = userDao;
    }


    @PostMapping("/login")
    public ResponseEntity<Account> add(@RequestBody Account account) {
        Account accountData = userDao.login(account);
        return new ResponseEntity<>(accountData, HttpStatus.CREATED);
    }

    @PostMapping("/register")
    public ResponseEntity<User> add(@RequestBody User user) {
        User userNew = userDao.register(user);
        return new ResponseEntity<>(userNew, HttpStatus.CREATED);
    }
}
