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

        System.out.println("GUestService");
        List<GuestDto> results = getJdbcTemplate().query(
                "select * from guest where id= ?", new Object[]{id},
                new RowMapper<GuestDto>() {
                    @Override
                    public GuestDto mapRow(ResultSet rs, int rowNum) throws SQLException {
                        return new GuestDto(rs.getLong("id"), rs.getString("firstName"),
                                rs.getString("lastName"));
                    }
                });

        for (GuestDto customer : results) {
            System.out.println(customer);
        }

        return results.get(0);
    }

    public void save(GuestDto guest) {
    }

    public void update(GuestDto guest) {

    }
}
