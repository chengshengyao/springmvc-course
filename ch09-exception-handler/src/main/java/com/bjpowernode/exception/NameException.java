package com.bjpowernode.exception;

/**
 * @ProjectName: springmvc-course
 * @Package: com.bjpowernode.exception
 * @Description: java类作用描述
 * @Author: 生尧
 * @CreateDate: 2021/1/20 17:24
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2021
 */
//当用户的姓名有异常时抛出姓名异常
public class NameException extends MyException{
    public NameException() {
        super();
    }

    public NameException(String message) {
        super(message);
    }
}
