package com.newmansoft.service;

import com.newmansoft.model.MealChoice;
import com.newmansoft.model.Status;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by user on 1/24/2015.
 */

@Service
public class StatusService extends Database{

    public List<Status> findAll() {
        List<Status> results = getJdbcTemplate().query(
                "select * from status",
                new RowMapper<Status>() {
                    @Override
                    public Status mapRow(ResultSet rs, int rowNum) throws SQLException {
                        return new Status(rs.getLong("id"), rs.getString("value"));
                    }
                });

        return results;
    }
}
