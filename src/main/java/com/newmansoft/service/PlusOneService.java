package com.newmansoft.service;

import com.newmansoft.model.MealChoice;
import com.newmansoft.model.PlusOne;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by user on 1/24/2015.
 */

@Service
public class PlusOneService extends Database{


    public int save(PlusOne plusOneInfo, Long id) {
        int res = getJdbcTemplate().update(
                "INSERT INTO plusone (guestID, name, mealId ) values(?,?,?)",
                id, plusOneInfo.getName(), plusOneInfo.getMealChoiceId());



        System.out.println("result:" + res);
       return res;

    }
}
