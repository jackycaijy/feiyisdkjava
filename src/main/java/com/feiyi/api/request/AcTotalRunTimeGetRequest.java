package com.feiyi.api.request;

import com.feiyi.api.ApiRuleException;
import com.feiyi.api.BaseFeiyiRequest;
import com.feiyi.api.internal.util.TaobaoHashMap;
import com.feiyi.api.response.AcStatusGetResponse;
import com.feiyi.api.response.AcTotalRunTimeGetResponse;

import java.util.Map;



public class AcTotalRunTimeGetRequest extends BaseFeiyiRequest<AcTotalRunTimeGetResponse> {

	public String getApiMethodName() {
		return "ac/totalRuntime";
	}

	public void setParamData(String account,String address,String date){
		putOtherTextParam("account",account);
		putOtherTextParam("address",address);
		putOtherTextParam("date",date);
	}

	public Map<String, String> getTextParams() {		
		TaobaoHashMap txtParams = new TaobaoHashMap();
		if(this.udfParams != null) {
			txtParams.putAll(this.udfParams);
		}
		return txtParams;
	}

	public Class<AcTotalRunTimeGetResponse> getResponseClass() {
		return AcTotalRunTimeGetResponse.class;
	}

	public void check() throws ApiRuleException {
	}
	

}