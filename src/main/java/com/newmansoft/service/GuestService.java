package com.newmansoft.service;

import com.newmansoft.model.GuestDto;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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
                                , rs.getString("notes"), rs.getLong("mealId"),  rs.getLong("statusId"), rs.getString("association"));
                    }
                });

        for (GuestDto customer : results) {
            System.out.println(customer);
        }

        return results.get(0);
    }

    public GuestDto save(GuestDto guest) {
        //http://stackoverflow.com/questions/16932814/unsure-how-to-return-generated-column-id-value-using-spring-jdbctemplate-and-pre
        int res = getJdbcTemplate().update(
                "INSERT INTO guest (firstName,lastName, phoneNumber, address, notes, mealId, statusId, association, email ) values(?,?,?,?,?,?,?,?,?)",
                guest.getFirstName(), guest.getLastName(), guest.getPhoneNumber(), guest.getAddress(), guest.getNotes(), guest.getMealId(),  guest.getStatusId(), guest.getAssociation(), guest.getEmail());



        System.out.println("result:" + res);
        guest.setId((long) res);

    return guest;

    }


    public List<GuestDto> findAll() {
        List<GuestDto> results = getJdbcTemplate().query(
                "select * from guest",
                new RowMapper<GuestDto>() {
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
