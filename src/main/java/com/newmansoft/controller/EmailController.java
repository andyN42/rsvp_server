package com.newmansoft.controller;


import com.newmansoft.model.EmailDto;
import com.newmansoft.model.GuestDto;
import com.newmansoft.service.GuestService;
import com.newmansoft.util.EmailLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/email")
public class EmailController {


    public EmailController() {

    }

    @RequestMapping(value = "/", method=RequestMethod.POST, consumes = "application/json")
    public ResponseEntity update(@RequestBody EmailDto emailDto) {
        EmailLogger.log(emailDto.getSubject(), emailDto.getBody(), emailDto.getAddress());
        return new ResponseEntity(HttpStatus.OK);

    }

}