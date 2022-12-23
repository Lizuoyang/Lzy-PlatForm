package com.lzy.platform.base.exception;

import com.lzy.platform.base.enums.ResultCodeEnum;
import lombok.Getter;
import lombok.Setter;

/**
 * @ClassName BusinessException
 * @Description 自定义业务异常类
 * @Author LiZuoYang
 * @Date 2022/6/8 15:13
 **/
@Getter
@Setter
public class BusinessException extends RuntimeException{
    private int code;

    private String msg;

    public BusinessException() {
        this.code = ResultCodeEnum.FAILED.code;
        this.msg = ResultCodeEnum.FAILED.msg;
    }

    public BusinessException(String message) {
        this.code = ResultCodeEnum.FAILED.code;
        this.msg = message;
    }

    public BusinessException(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }
}
