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
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.List;

@SpringBootTest
@Slf4j
/*@ExtendWith(OutputCaptureExtension.class)*/
class MybatisExApplicationTests {

    /*@Test
    void contextLoads(CapturedOutput output) {
        Assertions.assertThat(output.getOut()).contains("1,San Francisco,CA,US");
    }*/

    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    CityMapper cityMapper;

    @Test
    @DisplayName("조회")
    public void select(){
        City city = cityMapper.findById(1L);
        log.info("select : {}",city);
    }

    @Test
    @DisplayName("입력")
    @Transactional()
    public void insert(){
        City city = new City();
        city.setCountry("test1");
        city.setState("test1");
        city.setName("test1");
        cityMapper.insert(city);
        log.info("입력정보 : {}",city);
    }

    @Test
    @DisplayName("전체조회")
    public void findAll(){
        List<City> city = cityMapper.findAll();
        log.info("findAll : {}",city);
    }

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
