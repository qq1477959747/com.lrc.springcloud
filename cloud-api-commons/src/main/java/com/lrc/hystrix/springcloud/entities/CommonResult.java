package com.lrc.hystrix.springcloud.entities;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @USER luo
 * @Date 2021/7/30 22:49
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel
public class CommonResult<T> {
    @ApiModelProperty(value = "编码")
    private Integer code;
    @ApiModelProperty(value = "信息")
    private String message;
    @ApiModelProperty(value = "数据")
    private T data;

}
