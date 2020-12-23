package com.noxus.draven.swagger.controller;

import com.noxus.draven.swagger.entity.User;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 〈功能概述〉<br>
 *
 * @className: Swagger3Controller
 * @package: com.noxus.draven.swagger.controller
 * @author: draven
 * @date: 2020/12/23 09:21
 */
@RestController
@RequestMapping
@Api(tags = {"测试swagger3"})
public class Swagger3Controller {

    @Value("${swagger.application-description}")
    private String des;


    @ApiOperation(value = "测试swagger3",
            notes = "测试swagger3",
            response = User.class,
            responseContainer = "User"
            //produces = "application/json"
    )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "唯一", paramType = "query"),
            @ApiImplicitParam(name = "name", value = "名称", paramType = "query"),
            @ApiImplicitParam(name = "pass", value = "密码", paramType = "query"),
            @ApiImplicitParam(name = "User", value = "实体类", paramType = "body", dataTypeClass = User.class),
    })
    @ApiResponses({
            @ApiResponse(code = 0, message = "用户实体", response = User.class, reference = "")
    })
    @PostMapping(value = "test", produces = MediaType.APPLICATION_JSON_VALUE)
    public User test(@ApiParam(value = "用户实体") @RequestBody User user) {
        user.setName("1234");
        return user;
    }
}
