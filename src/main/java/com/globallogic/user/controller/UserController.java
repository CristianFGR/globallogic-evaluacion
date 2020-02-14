package com.globallogic.user.controller;

import com.globallogic.user.exception.ValidDataException;
import com.globallogic.user.model.UserContact;
import com.globallogic.user.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * Created by cristianfgr on 12-02-20.
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "Almacenamiento de data de usuario", response = UserContact.class)
    @PostMapping(value = "/user", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Optional<UserContact>> addUser(@RequestBody UserContact user) throws ValidDataException {
        return new ResponseEntity<>(userService.setUser(user), HttpStatus.CREATED);
    }

}
