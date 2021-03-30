package com.bjpowernode.vo;

/**
 * @ProjectName: springmvc-course
 * @Package: com.bjpowernode.vo
 * @Description: java类作用描述
 * @Author: 生尧
 * @CreateDate: 2021/1/18 9:20
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2021
 */
//保存请求参数值的一个普通类
public class Student {
    //属性名与请求时参数名一致
    private String name;
    private Integer age;
public Student(){
    System.out.println("Student的无参数构造方法");
}
    //Getter and Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("setName"+name);
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        System.out.println("setAge"+age);
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
