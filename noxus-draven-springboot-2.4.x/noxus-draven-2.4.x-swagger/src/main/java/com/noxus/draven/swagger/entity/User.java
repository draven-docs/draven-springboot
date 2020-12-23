package com.noxus.draven.swagger.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * 〈功能概述〉<br>
 *
 * @className: User
 * @package: com.noxus.draven.swagger.entity
 * @author: draven
 * @date: 2020/12/23 10:05
 */

@Data
@Setter
@Getter
@ApiModel(value = "user对象", description = "用户对象user")
public class User {
    @ApiParam("唯一")
    @ApiModelProperty(value = "唯一", name = "id",dataType = "String")
    private String id;

    @ApiParam("名称")
    @ApiModelProperty("名称")
    private String name;

    @ApiParam("密码")
    @ApiModelProperty("密码")
    private String pass;


    /**
     * value–字段说明
     * name–重写属性名字
     * dataType–重写属性类型
     * required–是否必填
     * example–举例说明
     * hidden–隐藏
     */
}
