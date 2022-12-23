package com.lzy.platform.base.exception;

import com.lzy.platform.base.enums.ResultCodeEnum;
import lombok.Getter;

/**
 * @ClassName BusinessException
 * @Description 自定义系统异常类
 * @Author LiZuoYang
 * @Date 2022/6/8 15:13
 **/
@Getter
public class SystemException extends RuntimeException{
    private int code;

    private String msg;

    public SystemException() {
        this.code = ResultCodeEnum.ERROR.code;
        this.msg = ResultCodeEnum.ERROR.msg;
    }

    public SystemException(String message) {
        this.code = ResultCodeEnum.ERROR.code;
        this.msg = message;
    }

    public SystemException(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public SystemException(Throwable cause) {
        super(cause);
    }

    public SystemException(String message, Throwable cause) {
        super(message, cause);
    }
}
