package com.example.mybatisex;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;

@SpringBootTest
@Slf4j
@ExtendWith(OutputCaptureExtension.class)
class MybatisExApplicationTests {


    //https://atoz-develop.tistory.com/entry/Spring-Boot-MyBatis-%EC%84%A4%EC%A0%95-%EB%B0%A9%EB%B2%95

    @Test
    void contextLoads(CapturedOutput output) {
        Assertions.assertThat(output.getOut()).contains("1,San Francisco,CA,US");
    }

    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    @DisplayName("DB커넥션 테스트")
    public void conn() throws Exception{
        Connection con = dataSource.getConnection();
        log.info("DBCP: " + dataSource.getClass());
        log.info("URL: " + con.getMetaData().getURL());
        log.info("UserName: " + con.getMetaData().getUserName());

        /*jdbcTemplate.execute("INSERT INTO ex1(name,nickname,position) values ('테스트','테스트','테스트')");*/

    }

}
