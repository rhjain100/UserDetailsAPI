package com.webapp.api.controller;

import com.webapp.api.model.request.UpdateUserDetailsRequestModel;
import com.webapp.api.model.request.UserDetailsRequestModel;
import com.webapp.api.model.response.UserRest;
import com.webapp.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(path = "/{user-id}")
    public ResponseEntity<UserRest> getUser(@PathVariable("user-id") String userId){
        ResponseEntity<UserRest> response = userService.getUser(userId);
        return response;
    }

    @PostMapping
    public ResponseEntity<UserRest> createUser(@RequestBody @Valid UserDetailsRequestModel userDetailsRequestModel){
        UserRest response =  userService.createUser(userDetailsRequestModel);
        return new ResponseEntity<>(response, new HttpHeaders(), HttpStatus.OK);
    }

    @PutMapping(path = "/{user-id}")
    public ResponseEntity<UserRest> updateUser(@PathVariable("user-id") String userId, @RequestBody @Valid UpdateUserDetailsRequestModel updateUser){
        UserRest response = userService.updateUser(userId,updateUser);
        return new ResponseEntity<>(response, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{user-id}")
    public ResponseEntity<UserRest> deleteUser(@PathVariable("user-id") String userId){
        ResponseEntity response = userService.deleteUser(userId);
        return response;
    }

}
