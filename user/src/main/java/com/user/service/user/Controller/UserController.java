package com.user.service.user.Controller;

import com.user.service.user.Model.UserData;
import com.user.service.user.Response.Response;
import com.user.service.user.Service.Service;
import com.user.service.user.customException.NullValueOrEmptyDataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    private Service service;

    @PostMapping("user")
    public ResponseEntity<Response>saveUserDatails(@RequestBody UserData userData) throws NullValueOrEmptyDataException {
        Response response =service.saveTheUserDetails(userData);
        return ResponseEntity.ok(response);
    }
    @GetMapping("user/{id}")
    public ResponseEntity<Response> getListOfUser(@PathVariable("id")Integer id ){
        Response response=service.getListOfUser(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/getAll/user")
    public List<UserData> getListOfUser(){
        return service.getAllUser();
    }

    @GetMapping("/get/AllProduct")
    public ResponseEntity<Response> getAllProduct(){
        Response response= service.getAllProduct();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
