package com.feiyi.api.test;

import com.feiyi.api.ApiException;
import com.feiyi.api.DefaultFeiyiClient;
import com.feiyi.api.FeiyiClient;
import com.feiyi.api.request.*;
import com.feiyi.api.request.dto.AcSetCmd;
import com.feiyi.api.response.*;

/**
 * Created by caijunyi on 2020/6/10.
 */
public class SdkClientTest {

    private static final String appkey = "1100001";
    private static final String secret = "8F4A5DA7041F2296A19A3D4A6165CF68";

    public  static void main(String[] args){

        getTime();
        acStatusGet();
        acStatusSet();
        acTotalRuntimeGet();
        acElecFeeDailyGet();
        allMeterGet();
        meterLogGet();

    }

    public static void getTime(){

        FeiyiClient client = new DefaultFeiyiClient(appkey, secret);

        TimeGetRequest req = new TimeGetRequest();

        //设置业务参数
        TimeGetResponse rsp = null;
        try {
            rsp = client.execute(req);
            System.out.println(rsp.getTime());
            System.out.println(rsp.getBody());
        } catch (ApiException e) {
            e.printStackTrace();
        }
    }


    public static void acStatusGet(){

        FeiyiClient client = new DefaultFeiyiClient(appkey, secret);

        AcStatusGetRequest req = new AcStatusGetRequest();

        //设置业务参数
        AcStatusGetResponse rsp = null;
        try {
            rsp = client.execute(req);
            System.out.println(rsp.getData());
            System.out.println(rsp.getBody());
        } catch (ApiException e) {
            e.printStackTrace();
        }
    }

    public static void acStatusSet(){

        FeiyiClient client = new DefaultFeiyiClient(appkey, secret);

        AcStatusSetRequest req = new AcStatusSetRequest();

        AcSetCmd cmd = new AcSetCmd();
        cmd.setAction(AcSetCmd.ACTION_SET);
        cmd.setAccount("bo_00024");
        cmd.setTemp("25");
        cmd.setSelectedAc("30-1-1-0");
        req.setAcSetCmd(cmd);
        //设置业务参数
        AcStatusSetResponse rsp = null;
        try {
            rsp = client.execute(req);
            System.out.println(rsp.getData());
            System.out.println(rsp.getBody());
        } catch (ApiException e) {
            e.printStackTrace();
        }
    }

    public static void acTotalRuntimeGet(){

        FeiyiClient client = new DefaultFeiyiClient(appkey, secret);

        AcTotalRunTimeGetRequest req = new AcTotalRunTimeGetRequest();

        req.setParamData("bo_00024","30-1-1-1","20200529");
        //设置业务参数
        AcTotalRunTimeGetResponse rsp = null;
        try {
            rsp = client.execute(req);
            System.out.println(rsp.getData());
            System.out.println(rsp.getBody());
        } catch (ApiException e) {
            e.printStackTrace();
        }
    }

    public static void acElecFeeDailyGet(){

        FeiyiClient client = new DefaultFeiyiClient(appkey, secret);

        AcElecFeeDailyGetRequest req = new AcElecFeeDailyGetRequest();

        req.setParamData("bo_00024","30-1-1-1","20200529");
        //设置业务参数
        AcTotalRunTimeGetResponse rsp = null;
        try {
            rsp = client.execute(req);
            System.out.println(rsp.getData());
            System.out.println(rsp.getBody());
        } catch (ApiException e) {
            e.printStackTrace();
        }
    }

    public static void allMeterGet(){

        FeiyiClient client = new DefaultFeiyiClient(appkey, secret);

        AllMeterGetRequest req = new AllMeterGetRequest();
        req.setParamData("bo_00024");
        try {
            AllMeterGetResponse rsp = client.execute(req);
            //System.out.println(rsp.getData().get(0).getMeterAddress());
            System.out.println(rsp.getBody());
        } catch (ApiException e) {
            e.printStackTrace();
        }
    }

    public static void meterLogGet(){

        FeiyiClient client = new DefaultFeiyiClient(appkey, secret);

        MeterLogGetRequest req = new MeterLogGetRequest();
        req.setParamData("bo_00024","30-10-0000000001","20200621");
        try {
            MeterLogGetResponse rsp = client.execute(req);
            //System.out.println(rsp.getData().getTotalUsage());
            System.out.println(rsp.getBody());
        } catch (ApiException e) {
            e.printStackTrace();
        }
    }


}
