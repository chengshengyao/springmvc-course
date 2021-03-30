package com.bjpw.controller;

import com.bjpw.entity.City;
import com.bjpw.model.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @ProjectName: mySpringMVC
 * @Package: com.bjpw.controller
 * @Description: java类作用描述
 * @Author: 程生鹏
 * @CreateDate: 2020/12/12 19:27
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2020
 */
@Controller
@RequestMapping("city")
public class CityController {
    @Autowired
    CityService cityService;
    @RequestMapping("list")
    public List<City> list(){
        return cityService.list();
    }
}
