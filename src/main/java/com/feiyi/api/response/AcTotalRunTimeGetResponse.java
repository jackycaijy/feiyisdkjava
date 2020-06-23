package com.feiyi.api.response;

import com.feiyi.api.FeiyiResponse;
import com.feiyi.api.internal.mapping.ApiField;
import com.feiyi.api.response.dto.AcTotalRuntime;


/**
 * TOP API: taobao.time.get response.
 * 
 * @author top auto create
 * @since 1.0, null
 */
public class AcTotalRunTimeGetResponse extends FeiyiResponse {

	private static final long serialVersionUID = 8726195255318242156L;

	@ApiField("data")
	private AcTotalRuntime data;

	public AcTotalRuntime getData() {
		return data;
	}

	public void setData(AcTotalRuntime data) {
		this.data = data;
	}
}
