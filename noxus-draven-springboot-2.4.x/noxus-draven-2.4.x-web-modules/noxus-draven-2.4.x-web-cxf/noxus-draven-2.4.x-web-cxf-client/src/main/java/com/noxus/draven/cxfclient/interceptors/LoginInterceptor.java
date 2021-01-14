package com.noxus.draven.cxfclient.interceptors;

import com.noxus.draven.cxfclient.config.CxfClientProperties;
import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.headers.Header;
import org.apache.cxf.helpers.DOMUtils;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.springframework.beans.factory.annotation.Autowired;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.namespace.QName;
import java.util.List;

//@Configuration
public class LoginInterceptor extends AbstractPhaseInterceptor<SoapMessage> {

    @Autowired
    private CxfClientProperties cxfClientProperties;

    private String username;

    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public LoginInterceptor() {
        //设置在发送请求前阶段进行拦截
        super(Phase.PREPARE_SEND);
    }

    @Override
    public void handleMessage(SoapMessage soapMessage) throws Fault {
        String username = cxfClientProperties.getUsername() == null ? "" : cxfClientProperties.getUsername();
        List<Header> headers = soapMessage.getHeaders();
        Document doc = DOMUtils.createDocument();
        // createElementNS namespace
        Element auth = doc.createElementNS(cxfClientProperties.getAddress(), "SecurityHeader");
        Element UserName = doc.createElement("username");
        Element UserPass = doc.createElement("password");

        UserName.setTextContent(cxfClientProperties.getUsername());
        UserPass.setTextContent(cxfClientProperties.getPassword());

        auth.appendChild(UserName);
        auth.appendChild(UserPass);

        headers.add(0, new Header(new QName("SecurityHeader"), auth));
    }
}
