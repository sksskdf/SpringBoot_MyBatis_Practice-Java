package com.example.mybatisex;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;

@SpringBootTest
@Slf4j
class MybatisExApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    public void conn() throws Exception{
        Connection con = dataSource.getConnection();
        log.info("DBCP: " + dataSource.getClass());
        log.info("URL: " + con.getMetaData().getURL());
        log.info("UserName: " + con.getMetaData().getUserName());

        jdbcTemplate.execute("INSERT INTO ex1(name,nickname,position) values ('테스트','테스트','테스트')");

    }

}
