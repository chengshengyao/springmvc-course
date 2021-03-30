package com.bjpowernode.exception;

/**
 * @ProjectName: springmvc-course
 * @Package: com.bjpowernode.exception
 * @Description: java类作用描述
 * @Author: 生尧
 * @CreateDate: 2021/1/20 17:23
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2021
 */
public class MyException extends Exception{
    public MyException() {
        super();
    }

    public MyException(String message) {
        super(message);
    }
}
