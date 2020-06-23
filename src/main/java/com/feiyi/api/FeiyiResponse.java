package com.feiyi.api;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by caijunyi on 2020/6/10.
 */
public abstract class FeiyiResponse implements Serializable {

    private static final long serialVersionUID = 5014379068811962022L;

    private String code;

    private String msg;

    private String subCode;

    private String subMsg;

    private String body; // API响应JSON或XML串

    private Map<String, String> params; // API请求参数列表

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getSubCode() {
        return this.subCode;
    }

    public void setSubCode(String subCode) {
        this.subCode = subCode;
    }

    public String getSubMsg() {
        return this.subMsg;
    }

    public void setSubMsg(String subMsg) {
        this.subMsg = subMsg;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Map<String, String> getParams() {
        return params;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }

    public boolean isSuccess() {
        return  "1".equals(this.code);
    }

}
