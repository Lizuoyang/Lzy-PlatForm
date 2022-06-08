package com.lzy.platform.springboot.common.base;

import com.lzy.platform.springboot.common.enums.ResultCodeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

/**
 * @ClassName Result
 * @Description 自定义分页响应消息类
 * @Author LiZuoYang
 * @Date 2022/6/8 14:54
 **/
@Getter
@ToString
@ApiModel("分页响应类")
public class PageResult<T> {
    @ApiModelProperty(value = "是否成功", required = true)
    private boolean success;

    @ApiModelProperty(value ="响应代码", required = true)
    private int code;

    @ApiModelProperty(value ="提示信息", required = true)
    private String msg;

    @ApiModelProperty(value ="总数量", required = true)
    private long count;

    @ApiModelProperty(value ="分页数据")
    private List<T> data;

    public PageResult(long total, List<T> rows) {
        this.count = total;
        this.data = rows;
        this.code = ResultCodeEnum.SUCCESS.code;
        this.msg = ResultCodeEnum.SUCCESS.msg;
    }
}
