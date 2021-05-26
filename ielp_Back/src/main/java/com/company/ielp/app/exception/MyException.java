package com.company.ielp.app.exception;

/**
 * 个人规定异常
 * @author 幕冬
 */
public class MyException extends RuntimeException {

    public MyException(String message) {
        super(message);
    }

    public MyException(String message, Throwable cause) {
        super(message, cause);
    }

}
