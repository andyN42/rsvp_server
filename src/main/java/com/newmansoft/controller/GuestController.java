package com.newmansoft.controller;


import com.newmansoft.model.GuestDto;

import com.newmansoft.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/guest")
public class GuestController {


    @Autowired
    private GuestService guestService;
    public GuestController() {

    }

    @RequestMapping("/{id}")
    public ResponseEntity<GuestDto> getGuest(@PathVariable String id) {
        GuestDto guestDto = guestService.find(id);
        if (guestDto != null) {
            return new ResponseEntity<GuestDto>(guestDto, HttpStatus.OK);
        }
        return new ResponseEntity<GuestDto>(HttpStatus.NOT_FOUND);

    }

    @RequestMapping(value = "/{id}", method=RequestMethod.PUT, consumes = "application/json")
    public ResponseEntity<GuestDto> update(@PathVariable String id,  @RequestBody GuestDto guestDto) {
        int result = guestService.updateGuest(guestDto, id);
        return new ResponseEntity<GuestDto>(guestDto, HttpStatus.OK);

    }
    @RequestMapping(value = "/", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<GuestDto > createGuest(@RequestBody GuestDto guestDto) {

        GuestDto updatedGuest = guestService.save(guestDto);

        return new ResponseEntity<GuestDto>(guestDto, HttpStatus.OK);
    }
}