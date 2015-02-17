package com.newmansoft.model.rowmapper;

import com.newmansoft.model.GuestDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by andyn on 2/16/2015.
 */
public class GuestRowMapper implements RowMapper<GuestDto> {
    @Override
    public GuestDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new GuestDto(rs.getLong("id"), rs.getString("firstName"),
                rs.getString("lastName"), rs.getString("phoneNumber"), rs.getString("address")
                , rs.getString("notes"), rs.getLong("mealId"),  rs.getLong("statusId"), rs.getString("association"), rs.getString("email"));
    }
}