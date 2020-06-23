package com.feiyi.api.internal.parser.xml;

import com.feiyi.api.ApiException;
import com.feiyi.api.FeiyiParser;
import com.feiyi.api.FeiyiResponse;
import com.feiyi.api.internal.mapping.Converter;


/**
 * 单个JSON对象解释器。
 * 
 * @author carver.gu
 * @since 1.0, Apr 11, 2010
 */
public class ObjectXmlParser<T extends FeiyiResponse> implements FeiyiParser<T> {

	private Class<T> clazz;

	public ObjectXmlParser(Class<T> clazz) {
		this.clazz = clazz;
	}

	public T parse(String rsp) throws ApiException {
		Converter converter = new XmlConverter();
		return converter.toResponse(rsp, clazz);
	}

	public Class<T> getResponseClass() {
		return clazz;
	}

}
