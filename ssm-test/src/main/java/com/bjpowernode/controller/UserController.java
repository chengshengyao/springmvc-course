package com.bjpowernode.controller;

import com.bjpowernode.pojo.User;
import com.bjpowernode.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    //查询
    @RequestMapping("userList")
    public ModelAndView findAll(){
        ModelAndView mav = new ModelAndView();
        //调用查询方法
        List<User> userList = userService.findAll();
        //返回数据
        mav.addObject("userList", userList);
        mav.setViewName("userList");
        return mav;
    }

    //用ID查询信息
    @RequestMapping("userEdit")
    public void userEdit(Model model, @RequestParam(value = "ID",required = true,defaultValue = "1")Integer ids){
        //调用查询方法 赋值给user
        User user = userService.findUserById(ids);
        //model返回数据模型
        model.addAttribute("user", user);
    }

    //修改
    @RequestMapping("updateUser")
    public String updateStudent(User user, Model model){
        //调用修改方法
        userService.updateUser(user);
        //model返回数据模型
        model.addAttribute("user", user);
        //转发到列表页面
        return "forward:userList.action";
    }

    //删除
    @RequestMapping("userDelete")
    public String studentDelete(int id){
        //调用删除方法
        userService.deleteUser(id);
        //转发到列表页面
        return "forward:userList.action";
    }

    //到添加页面
    @RequestMapping("userAdd")
    public void userAdd(){
    }

    //添加
    @RequestMapping("add")
    public String add(User user){
        //调用添加方法
        userService.add(user);
        //转发到列表页面
        return "forward:userList.action";
    }
}
