package com.newmansoft.service;

import com.newmansoft.model.GuestDto;
import org.springframework.stereotype.Service;

/**
 * Created by user on 1/24/2015.
 */

@Service
public class GuestService {


    public GuestDto find(String id) {
        GuestDto ret = new GuestDto();
        ret.setFirstName("Andy");
        ret.setLastName("Newman");
        return ret;

    }

    public void save(GuestDto guest) {
    }

    public void update(GuestDto guest) {

    }
}
