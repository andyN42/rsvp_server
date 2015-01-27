package com.newmansoft.controller;


import com.newmansoft.model.GuestDto;

import com.newmansoft.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//        import com.concretepage.component.IPersonService;
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
    @RequestMapping(value = "/", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<GuestDto > createGuest(@RequestBody GuestDto guestDto) {

        System.out.println("Create Guest!");
        guestService.save(guestDto);
        return new ResponseEntity<GuestDto>(guestDto, HttpStatus.OK);
    }
}