package com.newmansoft.controller;


import com.newmansoft.model.GuestDto;

import com.newmansoft.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//        import com.concretepage.component.IPersonService;
@RestController
//@RequestMapping("/guest")
public class GuestController {


    @Autowired
    private GuestService guestService;

    public GuestController() {

    }

    @RequestMapping("/guest")
    public GuestDto getPersonDetail(@RequestParam(value = "id", required = false,
            defaultValue = "0") String id) {


        return guestService.find(id);
    }

}