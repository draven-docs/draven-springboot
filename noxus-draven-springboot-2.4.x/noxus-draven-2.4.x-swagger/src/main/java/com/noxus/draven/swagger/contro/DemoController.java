package com.noxus.draven.swagger.contro;

import com.noxus.draven.swagger.entity.User;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 〈功能概述〉<br>
 *
 * @className: DemoController
 * @package: com.noxus.draven.swagger.contro
 * @author: draven
 * @date: 2020/12/23 09:47
 */
@RestController
@RequestMapping
public class DemoController {

    @Value("${swagger.application-description}")
    private String des;


    @ApiOperation("分页查询所有数据")
    @PostMapping("demo")
    public Object test(@RequestBody User user) {

        return user;
    }
}
