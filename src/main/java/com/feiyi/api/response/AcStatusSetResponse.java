package com.feiyi.api.response;

import com.feiyi.api.FeiyiResponse;
import com.feiyi.api.internal.mapping.ApiField;
import com.feiyi.api.response.dto.AccountAcInfo;

import java.util.List;



public class AcStatusSetResponse extends FeiyiResponse {

	private static final long serialVersionUID = 8726195255318242156L;

	@ApiField("data")
	private String data;

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
}
