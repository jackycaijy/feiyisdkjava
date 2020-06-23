package com.feiyi.api;

/**
 * Created by caijunyi on 2020/6/10.
 */
public interface FeiyiClient {

    /**
     * 执行公开API请求。
     *
     * @param <T> 具体的API响应类
     * @param request 具体的API请求类
     * @return 具体的API响应
     */
    public <T extends FeiyiResponse> T execute(FeiyiRequest<T> request) throws ApiException;

    /**
     * 执行隐私API请求。
     *
     * @param <T> 具体的API响应类
     * @param request 具体的API请求类
     * @param session 用户授权码
     * @return 具体的API响应
     */
    public <T extends FeiyiResponse> T execute(FeiyiRequest<T> request, String session) throws ApiException;

}
