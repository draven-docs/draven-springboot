package com.noxus.draven.hessians.interfaces.impl;

import com.noxus.draven.hessians.interfaces.SayHelloHessian;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author draven
 */
@Slf4j
@Service("sayHelloHessian")
public class SayHelloHessianImpl implements SayHelloHessian {

    //private Logger log = Logger.getLogger(SayHelloHessianImpl.class);

    @Override
    public String SayHello(String msg) {

        log.info("-----------进入hessian方法,客户端参数：" + msg + "--------------");

        return "服务端返回：hello hessian";
    }
}
