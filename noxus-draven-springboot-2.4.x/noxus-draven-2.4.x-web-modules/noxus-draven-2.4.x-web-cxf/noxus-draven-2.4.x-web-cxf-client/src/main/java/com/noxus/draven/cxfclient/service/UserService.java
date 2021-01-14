package com.noxus.draven.cxfclient.service;

import javax.jws.WebResult;
import javax.jws.WebService;

/**
 * @author draven
 * 指定webservice命名空间
 * No operation was found with the name
 */
@WebService(targetNamespace = "http://impl.service.cxfserver.draven.noxus.com/")
public interface UserService {


    /**
     * 在wsdl文档中显示的方法名，可不指定默认与方法相同；@WebMethod可不指定
     *
     * @param map
     * @return
     */
    @WebResult(name = "return")
    String getHello(String map);

}
