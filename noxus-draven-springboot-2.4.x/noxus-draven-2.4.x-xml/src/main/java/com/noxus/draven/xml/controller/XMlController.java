package com.noxus.draven.xml.controller;

import com.noxus.draven.xml.entity.RequetsXml;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 * 〈功能概述〉<br>
 * * http://www.lookdaima.com/WebForms/WebPages/Blanks/Pm/Docs/DocItemDetail.aspx?id=256858a9-e442-484e-878f-e1c54d6fceb5
 *
 * @className: XMlController
 * @package: com.noxus.draven.xml.controller
 * @author: draven
 * @date: 2021/7/8 09:40
 */

@RestController
@RequestMapping
@Slf4j
public class XMlController {

    @RequestMapping("/xmls")
    public RequetsXml xmls() throws JAXBException {
        RequetsXml root = new RequetsXml();

        root.setFileId("adsa45475454");

        RequetsXml.CaseFile caseFile = new RequetsXml.CaseFile();
        caseFile.setName("王凯");
        caseFile.setTmpFile(false);
        caseFile.setGroupId(1);
        caseFile.setSourceId(0);
        caseFile.setModifyTimStamp("1575454212");
        root.setCaseFile(caseFile);

        JAXBContext context = JAXBContext.newInstance(RequetsXml.class);
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        m.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.FALSE);
        m.setProperty(Marshaller.JAXB_ENCODING, "utf-8");
        m.marshal(root, System.out);
        return root;

    }
}
