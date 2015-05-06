package com.newmansoft.service;

import com.newmansoft.model.MealChoice;
import com.newmansoft.model.rowmapper.MealRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by user on 1/24/2015.
 */

@Service
public class MealService extends Database{

    public List<MealChoice> findAll() {
        List<MealChoice> results = getJdbcTemplate().query(
                "select * from meal",
                new MealRowMapper());

        return results;
    }


    public int save(MealChoice mealChoice) {


        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("name", mealChoice.getName());
        SimpleJdbcInsert insert = getJdbcInsert("meal");
        insert.withTableName("meal");
        insert.setGeneratedKeyName("id"); //e.g. "ID"
        Number key = insert.executeAndReturnKey(new MapSqlParameterSource(parameters));
        if (key != null) {
            mealChoice.setId(key.longValue());
        }

        return key.intValue();
    }

    public int update(String name, String id) {

        System.out.println("UPDATING MealChoice");
        int update = getJdbcTemplate().update(
                "update meal set " +
                        "name = ?" +
                        " where id= ? ",
                name, id);
        return update;
    }

    public int delete(String id) {

        System.out.println("Deleting MealChoice");
        int update = getJdbcTemplate().update(
                "delete from meal " +
                        " where id= ? ",
                id);
        return update;
    }

}
