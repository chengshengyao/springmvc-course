package com.bjpowernode.domain;

/**
 * @ProjectName: springmvc-course
 * @Package: com.bjpowernode.domain
 * @Description: java类作用描述
 * @Author: 生尧
 * @CreateDate: 2021/1/19 14:22
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2021
 */
public class Student {
    private String id;
    private String name;
    private Integer age;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
