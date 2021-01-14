package com.noxus.draven.cxfserver.service;

import com.fasterxml.jackson.core.JsonProcessingException;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * @author draven
 * 指定webservice命名空间
 * No operation was found with the name
 */
@WebService(targetNamespace = "http://impl.service.cxfserver.draven.noxus.com/",
        endpointInterface = "com.noxus.draven.cxfserver.service.UserService")
public interface UserService {

    /**
     * 在wsdl文档中显示的方法名，可不指定默认与方法相同；@WebMethod可不指定
     *
     * @param paramss
     * @return
     */
    @WebMethod(operationName = "getHello")
    String getHello( String paramss) throws JsonProcessingException;

}
