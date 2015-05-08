package com.newmansoft.service;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by andyn on 1/26/2015.
 */
@Service
public class Database {

    private SimpleDriverDataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcInsert insert;

    public SimpleDriverDataSource getDataSource() {
        return dataSource;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
    public  SimpleJdbcInsert getJdbcInsert(String tableName) {
        return new SimpleJdbcInsert(dataSource).withTableName(tableName);
    }

    public  Database() {
        dataSource = new SimpleDriverDataSource();
        dataSource.setDriverClass(com.mysql.jdbc.Driver.class);
//        dataSource.setUsername("newmansoft");
//        dataSource.setUrl("jdbc:mysql://db4free.net/newmansoftrsvp");
//        dataSource.setPassword("welc0me");
        // 'mattandjenn2015'@'localhost' to database 'rsvp'


        /**
         * Allowed Hosts
         * ch.astrahosting.com
         * s0106085b0e3f3a91.vc.shawcable.net
         * 24.84.216.170 (work)
         *
         */
        Properties prop = new Properties();
        try {
            String propLocation;
            Properties tempProp = new Properties();
            tempProp.load(this.getClass()
                    .getResourceAsStream("/rsvp.properties"));

            prop.load(new FileInputStream(tempProp.getProperty("properties_file")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String password = prop.getProperty("db_password");
        String username = prop.getProperty("db_username");
        String url = prop.getProperty("db_url");


        dataSource.setUsername(username);
        dataSource.setUrl(url);
        dataSource.setPassword(password);

        jdbcTemplate = new JdbcTemplate(dataSource);

    }



}
