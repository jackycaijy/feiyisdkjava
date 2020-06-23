package com.feiyi.api.response;

import com.feiyi.api.FeiyiResponse;
import com.feiyi.api.internal.mapping.ApiField;
import com.feiyi.api.response.dto.AcElecFeeDaily;


/**
 * TOP API: taobao.time.get response.
 * 
 * @author top auto create
 * @since 1.0, null
 */
public class AcElecFeeDailyGetResponse extends FeiyiResponse {

	private static final long serialVersionUID = 8726195255318242156L;

	@ApiField("data")
	private AcElecFeeDaily data;

	public AcElecFeeDaily getData() {
		return data;
	}

	public void setData(AcElecFeeDaily data) {
		this.data = data;
	}
}
