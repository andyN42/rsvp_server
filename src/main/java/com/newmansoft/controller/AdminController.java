package com.newmansoft.controller;

import com.newmansoft.model.GuestDto;
import com.newmansoft.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by andyn on 1/26/2015.
 */
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private GuestService guestService;


    @RequestMapping("/guests")
    public ResponseEntity<List<GuestDto>> getGuests() {
        List<GuestDto> guestDto = guestService.findAll();
        if (guestDto != null) {

            return new ResponseEntity<List<GuestDto>>(guestDto, HttpStatus.OK);
        }
        return new ResponseEntity<List<GuestDto>>(HttpStatus.NOT_FOUND);

    }
}
