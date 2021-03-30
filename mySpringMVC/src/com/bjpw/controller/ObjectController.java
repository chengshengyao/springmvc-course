package com.bjpw.controller;

import com.alibaba.fastjson.JSONObject;
import com.bjpw.entity.City;
import com.bjpw.model.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @ProjectName: mySpringMVC
 * @Package: com.bjpw.controller
 * @Description: java类作用描述
 * @Author: 程生鹏
 * @CreateDate: 2020/12/16 11:11
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2020
 */
@Controller
public class ObjectController {


    @Autowired
    private CityService cityService;

    /**
     * 最原始的方式，无返回值的方法
     * @param response
     * @throws IOException
     */
    @RequestMapping("/objectTest01")
    public void objectTest01(HttpServletResponse response) throws IOException {
        List<City> cities = cityService.list();
        String citiesJson = JSONObject.toJSONString(cities);
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(citiesJson);

    }
    @RequestMapping("/objectTest02")
    //@ResponseBody
    public @ResponseBody List<City> objectTest02(HttpServletResponse response) throws IOException {
        List<City> cities = cityService.list();
        String citiesJson = JSONObject.toJSONString(cities);
        return cities;


    }

    @RequestMapping("/objectTest03")
    //@ResponseBody
    public String objectTest03(HttpServletRequest request , Model model , ModelMap modelMap) throws IOException {
        //往request中放值
        //model.addAttribute("","");
        //modelMap.addAttribute("","");
        List<City> cities = cityService.list();
        request.setAttribute("cities",cities);
        return "../province";


    }
}
