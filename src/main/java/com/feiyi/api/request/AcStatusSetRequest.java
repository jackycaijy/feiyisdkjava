package com.feiyi.api.request;

import com.feiyi.api.ApiRuleException;
import com.feiyi.api.BaseFeiyiRequest;
import com.feiyi.api.internal.util.TaobaoHashMap;
import com.feiyi.api.request.dto.AcSetCmd;
import com.feiyi.api.response.AcStatusGetResponse;
import com.feiyi.api.response.AcStatusSetResponse;

import java.util.Map;


/**
 * TOP API: taobao.time.get request
 * 
 * @author top auto create
 * @since 1.0, 2016.03.28
 */
public class AcStatusSetRequest extends BaseFeiyiRequest<AcStatusSetResponse> {

	public String getApiMethodName() {
		return "ac/acSet";
	}

	public void setAcSetCmd(AcSetCmd cmd){
		if(AcSetCmd.ACTION_SET.equals(cmd.getAction())){
			putOtherTextParam("account",cmd.getAccount());
			putOtherTextParam("action",cmd.getAction());
			putOtherTextParam("temp",cmd.getTemp());
			putOtherTextParam("onOff",cmd.getOnOff());
			putOtherTextParam("workMode",cmd.getWorkMode());
			putOtherTextParam("selectedAc",cmd.getSelectedAc());
		}
	}

	public Map<String, String> getTextParams() {		
		TaobaoHashMap txtParams = new TaobaoHashMap();
		if(this.udfParams != null) {
			txtParams.putAll(this.udfParams);
		}
		return txtParams;
	}

	public Class<AcStatusSetResponse> getResponseClass() {
		return AcStatusSetResponse.class;
	}

	public void check() throws ApiRuleException {
	}
	

}