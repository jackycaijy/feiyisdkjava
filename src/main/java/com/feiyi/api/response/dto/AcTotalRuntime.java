package com.feiyi.api.response.dto;

import com.feiyi.api.FeiyiObject;

/**
 * Created by cjy on 2018/7/23.
 */
public class AcTotalRuntime extends FeiyiObject {

    private String logDate;
    private String address;
    private String thermoTime ;

    public String getLogDate() {
        return logDate;
    }

    public void setLogDate(String logDate) {
        this.logDate = logDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getThermoTime() {
        return thermoTime;
    }

    public void setThermoTime(String thermoTime) {
        this.thermoTime = thermoTime;
    }
}
