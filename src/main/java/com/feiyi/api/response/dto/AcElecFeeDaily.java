package com.feiyi.api.response.dto;

import com.feiyi.api.FeiyiObject;

/**
 * Created by cjy on 2018/7/23.
 */
public class AcElecFeeDaily extends FeiyiObject {

    private String divideDate;
    private String address;
    private String meterIuUsage ;
    private String meterIuUsageFee ;


    public String getDivideDate() {
        return divideDate;
    }

    public void setDivideDate(String divideDate) {
        this.divideDate = divideDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMeterIuUsage() {
        return meterIuUsage;
    }

    public void setMeterIuUsage(String meterIuUsage) {
        this.meterIuUsage = meterIuUsage;
    }

    public String getMeterIuUsageFee() {
        return meterIuUsageFee;
    }

    public void setMeterIuUsageFee(String meterIuUsageFee) {
        this.meterIuUsageFee = meterIuUsageFee;
    }
}
