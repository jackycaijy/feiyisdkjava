package com.feiyi.api.response.dto;

import com.feiyi.api.FeiyiObject;

/**
 * Created by cjy on 2018/7/23.
 */
public class MeterLog extends FeiyiObject {

    private String meterAddress;
    private String logDate;
    private String calcTodayUsage;
    private String totalUsage;

    public String getMeterAddress() {
        return meterAddress;
    }

    public void setMeterAddress(String meterAddress) {
        this.meterAddress = meterAddress;
    }

    public String getLogDate() {
        return logDate;
    }

    public void setLogDate(String logDate) {
        this.logDate = logDate;
    }

    public String getCalcTodayUsage() {
        return calcTodayUsage;
    }

    public void setCalcTodayUsage(String calcTodayUsage) {
        this.calcTodayUsage = calcTodayUsage;
    }

    public String getTotalUsage() {
        return totalUsage;
    }

    public void setTotalUsage(String totalUsage) {
        this.totalUsage = totalUsage;
    }
}
