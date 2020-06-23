package com.feiyi.api.response.dto;

import com.feiyi.api.FeiyiObject;

/**
 * Created by cjy on 2018/7/23.
 */
public class MeterInfo extends FeiyiObject {

    private String meterAddress;
    private String changeRatio;

    public String getMeterAddress() {
        return meterAddress;
    }

    public void setMeterAddress(String meterAddress) {
        this.meterAddress = meterAddress;
    }

    public String getChangeRatio() {
        return changeRatio;
    }

    public void setChangeRatio(String changeRatio) {
        this.changeRatio = changeRatio;
    }
}
