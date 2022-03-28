package com.example.mybatisex;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CityMapper {

    @Insert("INSERT INTO city (name,state,country) VALUES(#{name},#{state},#{country})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    void insert(City city);

    @Select("SELECT id,name,state,country FROM city WHERE id= #{id}")
    City findById(long id);

    @Select("SELECT * FROM city")
    List<City> findAll();
}
