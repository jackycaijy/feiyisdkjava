package com.feiyi.api.request.dto;


/**
 * Created by cjy on 2017/11/28.
 */
public class AcSetCmd {

    public static final String ACTION_SET = "Set";
    public static final String ACTION_LOCK = "Lock";

    private String account;
    private String action;

    private String onOff;
    private String temp;
    private String workMode;
    private String speed;

    private String onOffLock;
    private String workModeLock;
    private String speedLock;

    private String tempLock;
    private String tempHigh;
    private String tempLockLow;
    private String tempLow;

    private String selectedAc;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getSelectedAc() {
        return selectedAc;
    }

    public void setSelectedAc(String selectedAc) {
        this.selectedAc = selectedAc;
    }

    public String getAction() {
        return action;
    }
    public void setAction(String action) {
        this.action = action;
    }

    public String getOnOff() {
        return onOff;
    }
    public void setOnOff(String onOff) {
        this.onOff = onOff;
    }
    public String getTemp() {
        return temp;
    }
    public void setTemp(String temp) {
        this.temp = temp;
    }
    public String getWorkMode() {
        return workMode;
    }
    public void setWorkMode(String workMode) {
        this.workMode = workMode;
    }
    public String getSpeed() {
        return speed;
    }
    public void setSpeed(String speed) {
        this.speed = speed;
    }
    public String getOnOffLock() {
        return onOffLock;
    }
    public void setOnOffLock(String onOffLock) {
        this.onOffLock = onOffLock;
    }
    public String getWorkModeLock() {
        return workModeLock;
    }
    public void setWorkModeLock(String workModeLock) {
        this.workModeLock = workModeLock;
    }
    public String getSpeedLock() {
        return speedLock;
    }
    public void setSpeedLock(String speedLock) {
        this.speedLock = speedLock;
    }
    public String getTempLock() {
        return tempLock;
    }
    public void setTempLock(String tempLock) {
        this.tempLock = tempLock;
    }
    public String getTempHigh() {
        return tempHigh;
    }
    public void setTempHigh(String tempHigh) {
        this.tempHigh = tempHigh;
    }
    public String getTempLockLow() {
        return tempLockLow;
    }
    public void setTempLockLow(String tempLockLow) {
        this.tempLockLow = tempLockLow;
    }
    public String getTempLow() {
        return tempLow;
    }
    public void setTempLow(String tempLow) {
        this.tempLow = tempLow;
    }

    @Override
    public String toString() {
        return new StringBuilder("AcSetCmd [action=" ).append( action ).append( ", onOff=" ).append( onOff ).append( ", temp=" ).append( temp ).append( ", workMode=" ).append( workMode
        ).append( ", speed=" ).append( speed ).append( ", onOffLock=" ).append( onOffLock ).append( ", workModeLock=" ).append( workModeLock ).append( ", speedLock="
        ).append( speedLock ).append( ", tempLock=" ).append( tempLock ).append( ", tempHigh=" ).append( tempHigh ).append( ", tempLockLow=" ).append( tempLockLow
        ).append( ", tempLow=" ).append( tempLow ).append( "]").toString();
    }

    public static void main(String[] args){


    }

}
