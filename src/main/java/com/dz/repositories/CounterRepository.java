package com.dz.repositories;

import com.dz.models.CounterView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

@Component
public class CounterRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final String DAY_VIEW_QUERY = "with foo as(" +
            "  select user_id, count(*) as quantity from history where page_name = ? and extract(day from (now() - time_date)) = 0 group by user_id" +
            ")" +
            "select (select count(*) as all_views from foo), (select count(*) as unique_views from foo where quantity = 1), (select count(*) as permanent_views from foo where quantity >= 10);";

    private static final String INTERVAL_VIEW_QUERY = "with foo as(" +
            "  select user_id, count(*) as quantity from history where time_date >= ? and time_date <= ? group by user_id" +
            ")" +
            "select (select count(*) as all_views from foo), (select count(*) as unique_views from foo where quantity = 1), (select count(*) as permanent_views from foo where quantity >= 10);";

    private RowMapper<CounterView> rowMapper = new RowMapper<CounterView>() {
        @Override
        public CounterView mapRow(ResultSet rs, int rowNum) throws SQLException {
            return CounterView.builder()
                    .all(rs.getInt("all_views"))
                    .permanent(rs.getInt("permanent_views"))
                    .unique(rs.getInt("unique_views"))
                    .build();
        }
    };

    public CounterView getDayViews(String pageName){
        return jdbcTemplate.queryForObject(DAY_VIEW_QUERY, rowMapper, pageName);
    }

    public CounterView getIntervalViews(Timestamp start, Timestamp end){
        return jdbcTemplate.queryForObject(INTERVAL_VIEW_QUERY, rowMapper, start, end);
    }

}
