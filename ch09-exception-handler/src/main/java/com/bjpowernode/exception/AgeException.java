package com.bjpowernode.exception;

/**
 * @ProjectName: springmvc-course
 * @Package: com.bjpowernode.exception
 * @Description: java类作用描述
 * @Author: 生尧
 * @CreateDate: 2021/1/20 17:25
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2021
 */
//当用户的年龄有异常时抛出年龄异常
public class AgeException extends MyException{
    public AgeException() {
        super();
    }

    public AgeException(String message) {
        super(message);
    }
}
