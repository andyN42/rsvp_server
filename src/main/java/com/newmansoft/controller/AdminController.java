package com.newmansoft.controller;

import com.newmansoft.model.GuestDto;
import com.newmansoft.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by andyn on 1/26/2015.
 */
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private GuestService guestService;


    @RequestMapping(value = "/guestsX", method = RequestMethod.GET, produces= "application/xml")
    public ResponseEntity<List<GuestDto>> getGuests() {
        List<GuestDto> guestDto = guestService.findAll();
        if (guestDto != null) {

            return new ResponseEntity<List<GuestDto>>(guestDto, HttpStatus.OK);
        }
        return new ResponseEntity<List<GuestDto>>(HttpStatus.NOT_FOUND);

    }
    @RequestMapping(value = "/guestsJ", method = RequestMethod.GET, produces= "application/json")
    public ResponseEntity<List<GuestDto>> getGuestsJSON() {
        List<GuestDto> guestDto = guestService.findAll();
        if (guestDto != null) {

            return new ResponseEntity<List<GuestDto>>(guestDto, HttpStatus.OK);
        }
        return new ResponseEntity<List<GuestDto>>(HttpStatus.NOT_FOUND);

    }
}
