package com.newmansoft.controller;

import com.newmansoft.model.GuestDto;
import com.newmansoft.model.MealChoice;
import com.newmansoft.model.PlusOne;
import com.newmansoft.service.GuestService;
import com.newmansoft.service.MealService;
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

    @Autowired
    private MealService mealService;


    @RequestMapping(value = "/guests", method = RequestMethod.GET, produces= "application/json")
    public ResponseEntity<List<GuestDto>> getGuestsJSON(@RequestHeader(value="Authorization", required = false) String auth) {

        if (!"welc0me".equals(auth)) {
            return new ResponseEntity<List<GuestDto>>(HttpStatus.UNAUTHORIZED);
        }
        List<GuestDto> guests = guestService.findAll();

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



    @RequestMapping("/guests/{id}")
    public ResponseEntity<GuestDto> getGuest(@PathVariable String id, @RequestHeader(value="Authorization", required = false) String auth) {
        if (!"welc0me".equals(auth)) {
            return new ResponseEntity<GuestDto>(HttpStatus.UNAUTHORIZED);
        }

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

    @RequestMapping(value = "/guests/{id}", method=RequestMethod.PUT, consumes = "application/json")
    public ResponseEntity<GuestDto> update(@PathVariable String id,  @RequestBody GuestDto guestDto, @RequestHeader(value="Authorization", required = false) String auth) {

        if (!"welc0me".equals(auth)) {
            return new ResponseEntity<GuestDto>(HttpStatus.UNAUTHORIZED);
        }
        System.out.println("UPDATING GUEST");

        int result = guestService.updateGuest(guestDto, id);
        if (guestDto.getPlusOneInfo() != null) {
            plusOneService.updatePlusOne(guestDto.getPlusOneInfo(), id);
        }

        System.out.println("Result: " + result);
        return new ResponseEntity<GuestDto>(guestDto, HttpStatus.OK);

    }


    @RequestMapping(value = "/meal/{id}", method=RequestMethod.PUT, consumes = "application/json")
    public ResponseEntity<MealChoice> updateMeal(@PathVariable String id,  @RequestBody MealChoice mealChoice, @RequestHeader(value="Authorization", required = false) String auth) {

        if (!"welc0me".equals(auth)) {
            return new ResponseEntity<MealChoice>(HttpStatus.UNAUTHORIZED);
        }

        int update = mealService.update(mealChoice.getName(), id);
        return new ResponseEntity<MealChoice>(mealChoice, HttpStatus.OK);

    }


    @RequestMapping(value = "/meal/", method=RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<MealChoice> addMeal(  @RequestBody MealChoice mealChoice, @RequestHeader(value="Authorization", required = false) String auth) {

        if (!"welc0me".equals(auth)) {
            return new ResponseEntity<MealChoice>(HttpStatus.UNAUTHORIZED);
        }
        Integer update = mealService.save(mealChoice);
        mealChoice.setId(update.longValue());
        return new ResponseEntity<MealChoice>(mealChoice, HttpStatus.OK);

    }


}
