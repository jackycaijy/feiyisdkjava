package com.feiyi.api.response;

import com.feiyi.api.FeiyiResponse;
import com.feiyi.api.response.dto.AccountAcInfo;
import com.feiyi.api.response.dto.MeterInfo;

import java.util.List;


/**
 * FEIYI API: time.get response.
 * 
 * @author top auto create
 * @since 1.0, null
 */
public class AllMeterGetResponse extends FeiyiResponse {

	private static final long serialVersionUID = 8726195255318242156L;

	private List<MeterInfo> data;

	public List<MeterInfo> getData() {
		return data;
	}

	public void setData(List<MeterInfo> data) {
		this.data = data;
	}
}
