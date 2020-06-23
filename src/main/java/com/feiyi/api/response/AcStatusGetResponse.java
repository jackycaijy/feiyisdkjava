package com.feiyi.api.response;

import com.feiyi.api.FeiyiResponse;
import com.feiyi.api.internal.mapping.ApiField;
import com.feiyi.api.internal.util.GsonUtil;
import com.feiyi.api.internal.util.StringUtils;
import com.feiyi.api.response.dto.AccountAcInfo;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * TOP API: taobao.time.get response.
 * 
 * @author top auto create
 * @since 1.0, null
 */
public class AcStatusGetResponse extends FeiyiResponse {

	private static final long serialVersionUID = 8726195255318242156L;

	private List<AccountAcInfo> data;

	public List<AccountAcInfo> getData() {
		return data;
	}

	public void setData(List<AccountAcInfo> data) {
		this.data = data;
	}
}
