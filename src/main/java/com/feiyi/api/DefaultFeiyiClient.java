package com.feiyi.api;

import com.feiyi.api.internal.parser.json.ObjectJsonParser;
import com.feiyi.api.internal.parser.xml.ObjectXmlParser;
import com.feiyi.api.internal.util.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.IOException;
import java.util.Date;
import java.util.logging.Logger;

/**
 * Created by caijunyi on 2020/6/10.
 */
public class DefaultFeiyiClient implements FeiyiClient {

    private Log logger = LogFactory.getLog(this.getClass());

    protected String serverUrl;
    protected String appKey;
    protected String appSecret;
    protected String format = Constants.FORMAT_JSON;
    protected String signMethod = Constants.SIGN_METHOD_MD5;
    protected int connectTimeout = 15000; // 默认连接超时时间为15秒
    protected int readTimeout = 30000; // 默认响应超时时间为30秒
    protected boolean needCheckRequest = true; // 是否在客户端校验请求
    protected boolean needEnableParser = true; // 是否对响应结果进行解释
    protected boolean useSimplifyJson = false; // 是否采用精简化的JSON返回
    protected boolean useGzipEncoding = true; // 是否启用响应GZIP压缩


    public DefaultFeiyiClient(String appKey, String appSecret) {
        this.serverUrl = "http://wy.feiyikj.cn/open/";
        this.appKey = appKey;
        this.appSecret = appSecret;

    }

    public DefaultFeiyiClient(String serverUrl, String appKey, String appSecret) {
        this.appKey = appKey;
        this.appSecret = appSecret;
        this.serverUrl = serverUrl;
    }

    public DefaultFeiyiClient(String serverUrl, String appKey, String appSecret, String format) {
        this(serverUrl, appKey, appSecret);
        this.format = format;
    }

    public DefaultFeiyiClient(String serverUrl, String appKey, String appSecret, String format, int connectTimeout, int readTimeout) {
        this(serverUrl, appKey, appSecret, format);
        this.connectTimeout = connectTimeout;
        this.readTimeout = readTimeout;
    }

    public DefaultFeiyiClient(String serverUrl, String appKey, String appSecret, String format, int connectTimeout, int readTimeout, String signMethod) {
        this(serverUrl, appKey, appSecret, format, connectTimeout, readTimeout);
        this.signMethod = signMethod;
    }

    public <T extends FeiyiResponse> T execute(FeiyiRequest<T> request) throws ApiException {
        return execute(request, null);
    }

    public <T extends FeiyiResponse> T execute(FeiyiRequest<T> request, String session) throws ApiException {
        return _execute(request, session);
    }

    private <T extends FeiyiResponse> T _execute(FeiyiRequest<T> request, String session) throws ApiException {
        long start = System.currentTimeMillis();
        // 构建响应解释器
        FeiyiParser<T> parser = null;
        if (this.needEnableParser) {
            if (Constants.FORMAT_XML.equals(this.format)) {
                parser = new ObjectXmlParser<T>(request.getResponseClass());
            } else {
                parser = new ObjectJsonParser<T>(request.getResponseClass(), this.useSimplifyJson);
            }
        }

        // 本地校验请求参数
        if (this.needCheckRequest) {
            try {
                request.check();
            } catch (ApiRuleException e) {
                T localResponse = null;
                try {
                    localResponse = request.getResponseClass().newInstance();
                } catch (Exception xe) {
                    throw new ApiException(xe);
                }
                localResponse.setCode(e.getErrCode());
                localResponse.setMsg(e.getErrMsg());
                return localResponse;
            }
        }

        RequestParametersHolder requestHolder = new RequestParametersHolder();
        TaobaoHashMap appParams = new TaobaoHashMap(request.getTextParams());
        requestHolder.setApplicationParams(appParams);

        // 添加协议级请求参数
        TaobaoHashMap protocalMustParams = new TaobaoHashMap();
//        protocalMustParams.put(Constants.METHOD, request.getApiMethodName());
//        protocalMustParams.put(Constants.VERSION, "1.0");
        protocalMustParams.put(Constants.APP_KEY, appKey);
        Long timestamp = request.getTimestamp();
        if (timestamp == null) {
            timestamp = System.currentTimeMillis();
        }

        protocalMustParams.put(Constants.TIMESTAMP, timestamp);
        requestHolder.setProtocalMustParams(protocalMustParams);

        TaobaoHashMap protocalOptParams = new TaobaoHashMap();
//        protocalOptParams.put(Constants.FORMAT, format);
//        protocalOptParams.put(Constants.SIGN_METHOD, signMethod);
//        protocalOptParams.put(Constants.SESSION, session);
//        protocalOptParams.put(Constants.PARTNER_ID, getSdkVersion());
//        protocalOptParams.put(Constants.TARGET_APP_KEY, request.getTargetAppKey());

        if (this.useSimplifyJson) {
            protocalOptParams.put(Constants.SIMPLIFY, Boolean.TRUE.toString());
        }
        requestHolder.setProtocalOptParams(protocalOptParams);

        try {
            // 添加签名参数
            protocalMustParams.put(Constants.SIGN, FeiyiUtils.signTopRequest(requestHolder, appSecret, signMethod));

            String realServerUrl = getServerUrl(this.serverUrl, request.getApiMethodName(), session,appParams);
            String sysMustQuery = WebUtils.buildQuery(requestHolder.getProtocalMustParams(), Constants.CHARSET_UTF8);
            String sysOptQuery = WebUtils.buildQuery(requestHolder.getProtocalOptParams(), Constants.CHARSET_UTF8);
            String fullUrl = WebUtils.buildRequestUrl(realServerUrl, sysMustQuery, sysOptQuery);

            String rsp = null;
            // 是否需要压缩响应
            if (this.useGzipEncoding) {
                request.getHeaderMap().put(Constants.ACCEPT_ENCODING, Constants.CONTENT_ENCODING_GZIP);
            }
            rsp = WebUtils.doPost(fullUrl, appParams, Constants.CHARSET_UTF8, connectTimeout, readTimeout, request.getHeaderMap());
            logger.info("response raw data:" +rsp);
            requestHolder.setResponseBody(rsp);
        } catch (IOException e) {
            FeiyiLogger.logApiError(appKey, request.getApiMethodName(), serverUrl, requestHolder.getAllParams(), System.currentTimeMillis() - start, e.toString());
            throw new ApiException(e);
        }

        T tRsp = null;
        if (this.needEnableParser) {
            tRsp = parser.parse(requestHolder.getResponseBody());
            tRsp.setBody(requestHolder.getResponseBody());
        } else {
            try {
                tRsp = request.getResponseClass().newInstance();
                tRsp.setBody(requestHolder.getResponseBody());
            } catch (Exception e) {
                throw new ApiException(e);
            }
        }

        tRsp.setParams(appParams);
        if (!tRsp.isSuccess()) {
            FeiyiLogger.logApiError(appKey, request.getApiMethodName(), serverUrl, requestHolder.getAllParams(), System.currentTimeMillis() - start, tRsp.getBody());
        }
        return tRsp;
    }

    public String getServerUrl(String serverUrl, String apiName, String session,TaobaoHashMap appParams) {
        return serverUrl + apiName;
    }

    protected String getSdkVersion() {
        return Constants.SDK_VERSION;
    }

    /**
     * 是否在客户端校验请求参数。
     */
    public void setNeedCheckRequest(boolean needCheckRequest) {
        this.needCheckRequest = needCheckRequest;
    }

    /**
     * 是否把响应字符串解释为对象。
     */
    public void setNeedEnableParser(boolean needEnableParser) {
        this.needEnableParser = needEnableParser;
    }

    /**
     * 是否采用标准化的JSON格式返回。
     */
    public void setUseSimplifyJson(boolean useSimplifyJson) {
        this.useSimplifyJson = useSimplifyJson;
    }

    /**
     * 是否记录API请求错误日志。
     */
    public void setNeedEnableLogger(boolean needEnableLogger) {
        FeiyiLogger.setNeedEnableLogger(needEnableLogger);
    }

    /**
     * 是否忽略HTTPS证书校验。
     */
    public void setIgnoreSSLCheck(boolean ignore) {
        WebUtils.setIgnoreSSLCheck(ignore);
    }

    /**
     * 是否启用响应GZIP压缩
     */
    public void setUseGzipEncoding(boolean useGzipEncoding) {
        this.useGzipEncoding = useGzipEncoding;
    }

    /**
     * 设置API请求的连接超时时间，默认为15秒。
     */
    public void setConnectTimeout(int connectTimeout) {
        this.connectTimeout = connectTimeout;
    }

    /**
     * 设置API请求的读超时时间，默认为30秒。
     */
    public void setReadTimeout(int readTimeout) {
        this.readTimeout = readTimeout;
    }


}
