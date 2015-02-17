package com.newmansoft.service;

import com.newmansoft.model.GuestDto;
import com.newmansoft.model.rowmapper.GuestRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by user on 1/24/2015.
 */

@Service
public class GuestService  extends Database{


    public GuestDto find(String id) {

        System.out.println("GuestService finding " + id);
        List<GuestDto> results = getJdbcTemplate().query(
                "select * from guest where id= ?", new Object[]{id},
                new GuestRowMapper());

        for (GuestDto customer : results) {
            System.out.println(customer);
        }

        if (results != null && results.size()>0) {

            return results.get(0);
        }
        return null;
    }

    public List<GuestDto> findAll() {
        List<GuestDto> results = getJdbcTemplate().query(
                "select guest.* from guest",
                new GuestRowMapper());

        for (GuestDto customer : results) {
            System.out.println(customer);


        }

        return results;
    }

    public GuestDto save(GuestDto guest) {

        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("firstName", guest.getFirstName());
        parameters.put("lastName", guest.getLastName());
        parameters.put("phoneNumber", guest.getPhoneNumber());
        parameters.put("address", guest.getAddress());
        parameters.put("notes", guest.getNotes());
        parameters.put("mealId", guest.getMealId());
//        parameters.put("plusOneId", guest.getLastName());
        parameters.put("statusId", guest.getStatusId());
        parameters.put("email", guest.getEmail());
        parameters.put("association", guest.getAssociation());



        SimpleJdbcInsert insert = getJdbcInsert("guest");

        insert.withTableName("guest"); //e.g. "STUDENTS"

        insert.setGeneratedKeyName("id"); //e.g. "ID"

//        jdbcInsert.setColumnNames(columnNames)
//execute insert
        Number key =insert.executeAndReturnKey(new MapSqlParameterSource(parameters));
//set generated key
        if (key != null){
            guest.setId(key.longValue());
        }


    return guest;

    }


    public int updateGuest(GuestDto guest, String id ) {

        System.out.println("UPDATING GUEST");
        int update = getJdbcTemplate().update(
                "update guest set " +
                        "firstName = ? ," +
                        "lastName = ? ," +
                        "phoneNumber = ? ," +
                        "address = ? ," +
                        "notes= ? ," +
                        "mealId = ? ," +
                        "plusOneId = ? ," +
                        "statusId = ? ," +
                        "email = ? ," +
                        "association = ? " +
                        "where id = ?",
                guest.getFirstName(), guest.getLastName(), guest.getPhoneNumber(), guest.getAddress(), guest.getNotes(), guest.getMealId(), guest.getPlusOneInfo().getId(), guest.getStatusId()
                ,guest.getEmail(), guest.getAssociation(), id);
        return update;
    }
    public int updatePlusOne(long guestId, long plusOneId ) {
        int update = getJdbcTemplate().update(
                "update guest set plusOneId = ? where id = ?",
                plusOneId, guestId);
        return update;
    }

}
