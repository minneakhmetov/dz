package com.dz.repositories;

import com.dz.models.View;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
@Component
public class ViewRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final String INSERT = "INSERT INTO history (user_id, page_name, time_date) values (?, ?, ?)";

    public void save(View view){
        jdbcTemplate.update(INSERT, view.getUserId(), view.getPage(), Timestamp.valueOf(view.getTime()));
    }
}
