package com.lzy.platform.springboot.common.base;

import com.lzy.platform.springboot.common.enums.ResultCodeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Result
 * @Description 自定义通用响应消息类
 * @Author LiZuoYang
 * @Date 2022/6/8 14:54
 **/
@Data
@NoArgsConstructor
@ApiModel("通用响应类")
public class Result<T> {
    @ApiModelProperty("是否成功")
    private boolean success;
    @ApiModelProperty("提示消息")
    private String msg;
    @ApiModelProperty("响应代码")
    private int code;
    @ApiModelProperty("响应数据")
    private T data;

    private Result(int code, T data, String msg) {
        this.success = ResultCodeEnum.SUCCESS.code == code;
        this.msg = msg;
        this.code = code;
        this.data = data;
    }

    private Result(ResultCodeEnum resultCodeEnum) {
        this(resultCodeEnum.code, null, resultCodeEnum.msg);
    }

    private Result(ResultCodeEnum resultCodeEnum, String msg) {
        this(resultCodeEnum.code, null, msg);
    }

    private Result(ResultCodeEnum resultCodeEnum, T data) {
        this(resultCodeEnum.code, data, resultCodeEnum.msg);
    }

    private Result(ResultCodeEnum resultCodeEnum, T data, String msg) {
        this(resultCodeEnum.code, data, msg);
    }

    /**
     *
     *
     * @param data 数据
     * @param <T>  T 响应数据
     * @
     */
    public static <T> Result<T> data(T data) {
        return data(data, ResultCodeEnum.SUCCESS.msg);
    }

    /**
     *
     *
     * @param data 数据
     * @param msg  消息
     * @param <T>  T 响应数据
     * @
     */
    public static <T> Result<T> data(T data, String msg) {
        return data(ResultCodeEnum.SUCCESS.code, data, msg);
    }

    /**
     *
     *
     * @param code 状态码
     * @param data 数据
     * @param msg  消息
     * @param <T>  T 响应数据
     * @
     */
    public static <T> Result<T> data(int code, T data, String msg) {
        return new Result<>(code, data, msg);
    }

    /**
     * 返回Result
     *
     * @param
     * @param <T>  T 响应数据
     * @返回Result
     */
    public static <T> Result<T> success() {
        return new Result<>(ResultCodeEnum.SUCCESS);
    }

    /**
     * 返回Result
     *
     * @param msg 消息
     * @param <T> T 响应数据
     * @返回Result
     */
    public static <T> Result<T> success(String msg) {
        return new Result<>(ResultCodeEnum.SUCCESS, msg);
    }

    /**
     * 返回Result
     *
     * @param
     * @param <T>  T 响应数据
     * @返回Result
     */
    public static <T> Result<T> success(ResultCodeEnum resultCodeEnum ) {
        return new Result<>(resultCodeEnum);
    }

    /**
     * 返回Result
     *
     * @param
     * @param msg   提示信息
     * @param <T>  T 响应数据
     * @返回Result
     */
    public static <T> Result<T> success(ResultCodeEnum resultCodeEnum , String msg) {
        return new Result<>(resultCodeEnum, msg);
    }

    /**
     * 返回Result
     *
     * @param <T> T 响应数据
     * @返回Result
     */
    public static <T> Result<T> error() {
        return new Result<>(ResultCodeEnum.ERROR, ResultCodeEnum.ERROR.msg);
    }

    /**
     * 返回Result
     *
     * @param msg 消息
     * @param <T> T 响应数据
     * @返回Result
     */
    public static <T> Result<T> error(String msg) {
        return new Result<>(ResultCodeEnum.ERROR, msg);
    }


    /**
     * 返回Result
     *
     * @param code 状态码
     * @param msg  消息
     * @param <T>  T 响应数据
     * @返回Result
     */
    public static <T> Result<T> error(int code, String msg) {
        return new Result<>(code, null, msg);
    }

    /**
     * 返回Result
     *
     * @param
     * @param <T>  T 响应数据
     * @返回Result
     */
    public static <T> Result<T> error(ResultCodeEnum resultCodeEnum ) {
        return new Result<>(resultCodeEnum);
    }

    /**
     * 返回Result
     *
     * @param
     * @param msg   提示信息
     * @param <T>  T 响应数据
     * @返回Result
     */
    public static <T> Result<T> error(ResultCodeEnum resultCodeEnum , String msg) {
        return new Result<>(resultCodeEnum, msg);
    }

    /**
     *
     * @param <T>
     * @param flag
     * @return
     */
    public static <T> Result<T> result(boolean flag) {
        return flag ? Result.success("操作成功") : Result.error("操作失败");
    }
}
