package com.feiyi.api.request;

import com.feiyi.api.ApiRuleException;
import com.feiyi.api.BaseFeiyiRequest;
import com.feiyi.api.internal.util.TaobaoHashMap;
import com.feiyi.api.response.AllMeterGetResponse;
import com.feiyi.api.response.MeterLogGetResponse;

import java.util.Map;


/**
 * TOP API: taobao.time.get request
 * 
 * @author top auto create
 * @since 1.0, 2016.03.28
 */
public class MeterLogGetRequest extends BaseFeiyiRequest<MeterLogGetResponse> {

	public String getApiMethodName() {
		return "meter/meterLog";
	}

	public void setParamData(String account,String meterAddress,String logDate){

		putOtherTextParam("account",account);
		putOtherTextParam("meterAddress",meterAddress);
		putOtherTextParam("date",logDate);
	}

	public Map<String, String> getTextParams() {		
		TaobaoHashMap txtParams = new TaobaoHashMap();
		if(this.udfParams != null) {
			txtParams.putAll(this.udfParams);
		}
		return txtParams;
	}

	public Class<MeterLogGetResponse> getResponseClass() {
		return MeterLogGetResponse.class;
	}

	public void check() throws ApiRuleException {
	}
	

}