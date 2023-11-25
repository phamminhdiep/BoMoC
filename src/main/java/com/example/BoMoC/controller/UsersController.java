package com.example.BoMoC.controller;

import com.example.BoMoC.Model.Product.Clothes;
import com.example.BoMoC.Model.User.Account;
import com.example.BoMoC.Model.User.User;
import com.example.BoMoC.controller.UserDao.UserDao;
import com.example.BoMoC.controller.UserDao.UserImplement;
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
