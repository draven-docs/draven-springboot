package com.noxus.draven.xml.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "request")
public class RequetsXml {

    @XmlElement(name = "casefile")
    private CaseFile caseFile;

    @XmlElement(name = "uploaded-file-id")
    private String fileId;


    public void setCaseFile(CaseFile caseFile) {
        this.caseFile = caseFile;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public static class CaseFile {

        private String name;

        @XmlElement(name = "isTmpFile")
        private boolean isTmpFile;

        @XmlElement(name = "modify-timestamp")
        private String modifyTimStamp;

        @XmlElement(name = "sdb-group-id")
        private Integer groupId;

        @XmlElement(name = "source-system-id")
        private Integer sourceId;


        public void setName(String name) {
            this.name = name;
        }


        public void setTmpFile(boolean tmpFile) {
            isTmpFile = tmpFile;
        }


        public void setModifyTimStamp(String modifyTimStamp) {
            this.modifyTimStamp = modifyTimStamp;
        }

        public void setGroupId(Integer groupId) {
            this.groupId = groupId;
        }

        public void setSourceId(Integer sourceId) {
            this.sourceId = sourceId;
        }
    }
}
