package com.bjpw.model.service;

import com.bjpw.entity.City;
import com.bjpw.model.dao.CityDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ProjectName: mySpringMVC
 * @Package: com.bjpw.model.service
 * @Description: java类作用描述
 * @Author: 程生鹏
 * @CreateDate: 2020/12/12 16:27
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2020
 */
@Service
public class CityServiceImpl implements CityService{

    @Autowired
    CityDao cityDao;
    @Override
    public List<City> list() {
        return cityDao.selectAll();
    }
}
