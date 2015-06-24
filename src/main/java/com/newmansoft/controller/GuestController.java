package com.newmansoft.controller;


import com.newmansoft.model.GuestDto;

import com.newmansoft.service.GuestService;
import com.newmansoft.util.EmailLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@RestController
@RequestMapping("/guest")
public class GuestController {


    private  String loggingEmail = "andyandem2016+server@gmail.com";
    @Autowired
    private GuestService guestService;



    String serverName = null;

    public GuestController() {

        Properties prop = new Properties();
        try {
            String propLocation;
            Properties tempProp = new Properties();
            tempProp.load(this.getClass()
                    .getResourceAsStream("/rsvp.properties"));

            prop.load(new FileInputStream(tempProp.getProperty("properties_file")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        serverName = prop.getProperty("server");
        if (serverName == null) {
            serverName = "UNKOWN_SERVER ";
        }
        String tempLoggingEmail = prop.getProperty("loggingEmail");
        if (tempLoggingEmail != null) {
            loggingEmail = tempLoggingEmail;
        }
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

        /**
         * Before you do any DB work, log it to email
         */
        EmailLogger.log(serverName + " GuestController.update", guestDto, loggingEmail);

        int result = guestService.updateGuest(guestDto, id);





        return new ResponseEntity<GuestDto>(guestDto, HttpStatus.OK);

    }
    @RequestMapping(value = "/", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<GuestDto > createGuest(@RequestBody GuestDto guestDto) {

        /**
         * Before you do any DB work, log it to email
         */
        EmailLogger.log(serverName + " GuestController.create", guestDto, loggingEmail);

        GuestDto updatedGuest = guestService.save(guestDto);

        return new ResponseEntity<GuestDto>(guestDto, HttpStatus.OK);
    }
}