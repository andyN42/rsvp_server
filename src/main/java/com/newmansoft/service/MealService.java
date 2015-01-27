package com.newmansoft.service;

import com.newmansoft.model.GuestDto;
import com.newmansoft.model.MealChoice;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by user on 1/24/2015.
 */

@Service
public class MealService extends Database{

    public List<MealChoice> findAll() {
        List<MealChoice> results = getJdbcTemplate().query(
                "select * from meal",
                new RowMapper<MealChoice>() {
                    @Override
                    public MealChoice mapRow(ResultSet rs, int rowNum) throws SQLException {
                        return new MealChoice(rs.getLong("id"), rs.getString("name"));
                    }
                });

        return results;
    }
}
