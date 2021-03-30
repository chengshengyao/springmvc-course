package com.bjpw.model.service;

import com.bjpw.entity.City;

import java.util.List;

/**
 * @ProjectName: mySpringMVC
 * @Package: com.bjpw.model.service
 * @Description: java类作用描述
 * @Author: 程生鹏
 * @CreateDate: 2020/12/12 16:24
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2020
 */
public interface CityService {
    //查询所有的方法
    List<City> list();

}
