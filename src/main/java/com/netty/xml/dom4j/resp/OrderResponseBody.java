package com.netty.xml.dom4j.resp;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author juebing
 * @date 2018/11/23 11:56
 * @description
 */
@XmlType(propOrder = {"status", "respCode", "respDesc", "completeTime"})
public class OrderResponseBody {
    private String status;
    private String respCode;
    private String respDesc;
    private String completeTime;

    public OrderResponseBody() {
    }

    @XmlElement(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @XmlElement(name = "respCode")
    public String getRespCode() {
        return respCode;
    }

    public void setRespCode(String respCode) {
        this.respCode = respCode;
    }

    @XmlElement(name = "respDesc")
    public String getRespDesc() {
        return respDesc;
    }

    public void setRespDesc(String respDesc) {
        this.respDesc = respDesc;
    }

    @XmlElement(name = "completeTime")
    public String getCompleteTime() {
        return completeTime;
    }

    public void setCompleteTime(String completeTime) {
        this.completeTime = completeTime;
    }

    @Override
    public String toString() {
        return "OrderResponseBody{" +
                "status='" + status + '\'' +
                ", respCode='" + respCode + '\'' +
                ", respDesc='" + respDesc + '\'' +
                ", completeTime='" + completeTime + '\'' +
                '}';
    }
}