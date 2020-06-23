package com.feiyi.api.request;

import com.feiyi.api.ApiRuleException;
import com.feiyi.api.BaseFeiyiRequest;
import com.feiyi.api.internal.util.TaobaoHashMap;
import com.feiyi.api.response.TimeGetResponse;

import java.util.Map;


/**
 * TOP API: taobao.time.get request
 * 
 * @author top auto create
 * @since 1.0, 2016.03.28
 */
public class TimeGetRequest extends BaseFeiyiRequest<TimeGetResponse> {
	
	

	public String getApiMethodName() {
		return "comm/getTime";
	}

	public Map<String, String> getTextParams() {		
		TaobaoHashMap txtParams = new TaobaoHashMap();
		if(this.udfParams != null) {
			txtParams.putAll(this.udfParams);
		}
		return txtParams;
	}

	public Class<TimeGetResponse> getResponseClass() {
		return TimeGetResponse.class;
	}

	public void check() throws ApiRuleException {
	}
	

}