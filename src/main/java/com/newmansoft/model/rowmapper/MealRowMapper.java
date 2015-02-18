package com.newmansoft.model.rowmapper;

import com.newmansoft.model.MealChoice;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by andyn on 2/18/2015.
 */
public class MealRowMapper implements RowMapper<MealChoice> {
        @Override
        public MealChoice mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new MealChoice(rs.getLong("id"), rs.getString("name"));
        }
    }
