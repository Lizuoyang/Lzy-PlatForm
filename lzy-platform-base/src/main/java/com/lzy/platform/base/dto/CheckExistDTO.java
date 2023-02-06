package com.lzy.platform.base.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassName CheckExistDto
 * @Description 校验某个对象字段是否存在
 * @Author LiZuoYang
 * @Date 2023/2/6 10:21
 **/
@Data
@ApiModel(value = "CheckExist对象", description = "校验某个对象字段是否存在")
public class CheckExistDTO {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "检查字段")
    private String checkField;

    @ApiModelProperty(value = "检查字段的值")
    private String checkValue;

}
