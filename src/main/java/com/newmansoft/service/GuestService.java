package com.newmansoft.service;

import com.newmansoft.model.GuestDto;
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
                new RowMapper<GuestDto>() {
                    @Override
                    public GuestDto mapRow(ResultSet rs, int rowNum) throws SQLException {
                        return new GuestDto(rs.getLong("id"), rs.getString("firstName"),
                                rs.getString("lastName"), rs.getString("phoneNumber"), rs.getString("address")
                                , rs.getString("notes"), rs.getLong("mealId"),  rs.getLong("statusId"), rs.getString("association"), rs.getString("email"));
                    }
                });

        for (GuestDto customer : results) {
            System.out.println(customer);
        }

        if (results != null && results.size()>0) {

            return results.get(0);
        }
        return null;
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

    public int updatePlusOne(long guestId, long plusOneId ) {
        int update = getJdbcTemplate().update(
                "update guest set plusOneId = ? where id = ?",
                plusOneId, guestId);
        return update;
    }
//


    //  "select guest.*   , plusone.* from guest, plusone where plusone.guestID = guest.id",



    public List<GuestDto> findAll() {
        List<GuestDto> results = getJdbcTemplate().query(
                "select guest.* from guest",
                new RowMapper<GuestDto>() {
                    /*
                      this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.notes = notes;
        this.mealId = mealId;
        this.statusId = statusId;
        this.association = association;
                     */
                    @Override
                    public GuestDto mapRow(ResultSet rs, int rowNum) throws SQLException {
                        return new GuestDto(rs.getLong("id"), rs.getString("firstName"),
                                rs.getString("lastName"), rs.getString("phoneNumber"), rs.getString("address")
                                , rs.getString("notes"), rs.getLong("mealId"), rs.getLong("statusId"), rs.getString("association"));
                    }
                });

        for (GuestDto customer : results) {
            System.out.println(customer);
        }

        return results;
    }
}
