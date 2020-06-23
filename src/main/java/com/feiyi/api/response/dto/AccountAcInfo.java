package com.feiyi.api.response.dto;

import com.feiyi.api.FeiyiObject;

import java.util.List;

/**
 * Created by cjy on 2018/7/23.
 */
public class AccountAcInfo extends FeiyiObject {

    private String account;
    private List<AcIuStatusSimple> acStatus;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public List<AcIuStatusSimple> getAcStatus() {
        return acStatus;
    }

    public void setAcStatus(List<AcIuStatusSimple> acStatus) {
        this.acStatus = acStatus;
    }
}
