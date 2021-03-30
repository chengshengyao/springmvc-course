package com.bjpw.model.dao;

import com.bjpw.entity.City;

import java.util.List;

public interface CityDao {
    int deleteByPrimaryKey(Integer cid);

    int insert(City record);

    int insertSelective(City record);

    City selectByPrimaryKey(Integer cid);

    List<City> selectAll();

    int updateByPrimaryKeySelective(City record);

    int updateByPrimaryKey(City record);
}