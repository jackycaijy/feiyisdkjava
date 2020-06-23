package com.feiyi.api.response;

import com.feiyi.api.FeiyiResponse;
import com.feiyi.api.internal.mapping.ApiField;
import com.feiyi.api.response.dto.MeterInfo;
import com.feiyi.api.response.dto.MeterLog;

import java.util.List;


/**
 * FEIYI API: time.get response.
 * 
 * @author top auto create
 * @since 1.0, null
 */
public class MeterLogGetResponse extends FeiyiResponse {

	private static final long serialVersionUID = 8726195255318242156L;

	@ApiField("data")
	private MeterLog data;

	public MeterLog getData() {
		return data;
	}

	public void setData(MeterLog data) {
		this.data = data;
	}
}
