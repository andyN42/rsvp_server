package com.newmansoft.controller;

import com.newmansoft.model.GuestDto;
import com.newmansoft.model.PlusOne;
import com.newmansoft.service.GuestService;
import com.newmansoft.service.PlusOneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by andyn on 1/26/2015.
 */
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private GuestService guestService;

    @Autowired
    private PlusOneService plusOneService;


    @RequestMapping(value = "/guestsX", method = RequestMethod.GET, produces= "application/xml")
    public ResponseEntity<List<GuestDto>> getGuests() {
        List<GuestDto> guestDto = guestService.findAll();
        if (guestDto != null) {

            return new ResponseEntity<List<GuestDto>>(guestDto, HttpStatus.OK);
        }
        return new ResponseEntity<List<GuestDto>>(HttpStatus.NOT_FOUND);

    }
    @RequestMapping(value = "/guestsJ", method = RequestMethod.GET, produces= "application/json")
    public ResponseEntity<List<GuestDto>> getGuestsJSON(@RequestHeader(value="Authorization", required = false) String auth) {
        List<GuestDto> guests = guestService.findAll();

        if (!"welc0me".equals(auth)) {
            return new ResponseEntity<List<GuestDto>>(HttpStatus.UNAUTHORIZED);
        }
        if (guests != null) {

            for(GuestDto guest : guests) {
                PlusOne plusOne = plusOneService.findPlusOneForGuestId(guest.getId().toString());
                if (plusOne != null) {
                    guest.setPlusOneInfo(plusOne);
                }

            }
            return new ResponseEntity<List<GuestDto>>(guests, HttpStatus.OK);
        }
        return new ResponseEntity<List<GuestDto>>(HttpStatus.NOT_FOUND);

    }
}
