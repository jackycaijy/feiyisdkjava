package com.feiyi.api.response;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.feiyi.api.FeiyiResponse;
import com.feiyi.api.internal.mapping.ApiField;
import com.feiyi.api.internal.util.StringUtils;


/**
 * FEIYI API: time.get response.
 * 
 * @author top auto create
 * @since 1.0, null
 */
public class TimeGetResponse extends FeiyiResponse {

	private static final long serialVersionUID = 8726195255318242156L;

	/** 
	 * 系统当前时间。格式:yyyy-MM-dd HH:mm:ss
	 */
	@ApiField("data")
	private String data;

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Date getTime(){
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			if(StringUtils.areNotEmpty(data)){
				return sf.parse(data);
			}

		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

}
