package pulsar.plus.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pulsar.plus.entity.TOrder1;
import pulsar.plus.service.TOrder1Service;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author draven
 * @since 2021-05-29
 */
@RestController
@RequestMapping("/plus/t-order1")
public class TOrder1Controller {


    @Autowired
    private TOrder1Service tOrder1Service;


    @RequestMapping("/list")
    public List<TOrder1> getTOrder1() {
        List<TOrder1> tOrder1 = tOrder1Service.list();
        return tOrder1;
    }
}

