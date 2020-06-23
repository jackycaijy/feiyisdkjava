package com.feiyi.api.response.dto;

import com.feiyi.api.FeiyiObject;

/**
 * Created by cjy on 2018/7/23.
 */
public class AcIuStatusSimple extends FeiyiObject {

    private String status;
    private String address;
    //private int gwNo;
    //private int ouNo;
    //private int iuNo;
    private String errorCode = "";
    private int onOff;
    private int runMode;
    private int fanSpeed;
    private int tempSet;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

//    public int getGwNo() {
//        return gwNo;
//    }
//
//    public void setGwNo(int gwNo) {
//        this.gwNo = gwNo;
//    }
//
//    public int getOuNo() {
//        return ouNo;
//    }
//
//    public void setOuNo(int ouNo) {
//        this.ouNo = ouNo;
//    }
//
//    public int getIuNo() {
//        return iuNo;
//    }
//
//    public void setIuNo(int iuNo) {
//        this.iuNo = iuNo;
//    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public int getOnOff() {
        return onOff;
    }

    public void setOnOff(int onOff) {
        this.onOff = onOff;
    }

    public int getRunMode() {
        return runMode;
    }

    public void setRunMode(int runMode) {
        this.runMode = runMode;
    }

    public int getFanSpeed() {
        return fanSpeed;
    }

    public void setFanSpeed(int fanSpeed) {
        this.fanSpeed = fanSpeed;
    }

    public int getTempSet() {
        return tempSet;
    }

    public void setTempSet(int tempSet) {
        this.tempSet = tempSet;
    }
}
