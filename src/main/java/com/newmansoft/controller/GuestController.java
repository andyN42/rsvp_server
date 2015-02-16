package com.newmansoft.controller;


import com.newmansoft.model.GuestDto;

import com.newmansoft.model.PlusOne;
import com.newmansoft.service.GuestService;
import com.newmansoft.service.PlusOneService;
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
    @Autowired
    private PlusOneService plusOneService;
    public GuestController() {

    }

    @RequestMapping("/{id}")
    public ResponseEntity<GuestDto> getGuest(@PathVariable String id) {
        GuestDto guestDto = guestService.find(id);
        if (guestDto != null) {

            PlusOne plusOne = plusOneService.findPlusOneForGuestId(id);
            if (plusOne != null) {
                guestDto.setPlusOneInfo(plusOne);
            }

            return new ResponseEntity<GuestDto>(guestDto, HttpStatus.OK);
        }
        return new ResponseEntity<GuestDto>(HttpStatus.NOT_FOUND);

    }

    @RequestMapping(value = "/{id}", method=RequestMethod.PUT, consumes = "application/json")
    public ResponseEntity<GuestDto> update(@PathVariable String id,  @RequestBody GuestDto guestDto) {
        System.out.println("UPDATING GUEST");

        int result = guestService.updateGuest(guestDto, id);
        if (guestDto.getPlusOneInfo() != null) {
            plusOneService.updatePlusOne(guestDto.getPlusOneInfo(), id);
        }

        System.out.println("Result: " + result);
        return new ResponseEntity<GuestDto>(guestDto, HttpStatus.OK);

    }
    @RequestMapping(value = "/", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<GuestDto > createGuest(@RequestBody GuestDto guestDto) {

        System.out.println("Create Guest!");
        GuestDto updatedGuest = guestService.save(guestDto);

        if (updatedGuest.getPlusOneInfo() != null) {
            plusOneService.save(updatedGuest.getPlusOneInfo(), updatedGuest.getId());

        }
        return new ResponseEntity<GuestDto>(guestDto, HttpStatus.OK);
    }
}