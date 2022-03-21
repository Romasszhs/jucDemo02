package com.hang.SMS;

import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;
import com.tencentcloudapi.sms.v20190711.SmsClient;
import com.tencentcloudapi.sms.v20190711.models.SendSmsRequest;
import com.tencentcloudapi.sms.v20190711.models.SendSmsResponse;

/**
 * @author: hangshuo
 * @date: 2021/08/03 19:02
 * @Description:
 */

public class SendSms {
    static final String secretID = "AKIDkNqAHEzWpvqa7RabPxFI9nCMG4i8IBpC";
    static final String secretkey = "DIBqKbeTCl7GBtNdfhifXL6pXBnIfxDR";

    public static void main(String[] args) {
        sendSms("15812497769","123456");


    }

    public static void sendSms(String mobile,String code){
        try {
            Credential cred = new Credential(secretID,secretkey);

            /*HttpProfile httpProfile = new HttpProfile();
            httpProfile.setReqMethod("POST");
            httpProfile.setConnTimeout(60);
            httpProfile.setEndpoint("sms.tencentcloudapi.com");*/

            ClientProfile clientProfile = new ClientProfile();
            clientProfile.setSignMethod("HmacSHA256");
            //clientProfile.setHttpProfile(httpProfile);
            SmsClient client = new SmsClient(cred, "", clientProfile);

            SendSmsRequest req = new SendSmsRequest();

            String appid = "1400547594";
            req.setSmsSdkAppid(appid);

            String sign = "青路科技";// 直接是签名中的内容，而不是指定的ID
            req.setSign(sign);

            String templateID = "1031401";
            req.setTemplateID(templateID);

            String Splicingphone ="+86"+mobile;
            String[] phoneNumbers = {Splicingphone};
            req.setPhoneNumberSet(phoneNumbers);

            String[] templateParams = {code};
            req.setTemplateParamSet(templateParams);

            SendSmsResponse response = client.SendSms(req);

            // 输出json格式的字符串回包
            System.out.println(SendSmsResponse.toJsonString(response));

            // 也可以取出单个值，你可以通过官网接口文档或跳转到response对象的定义处查看返回字段的定义
            //System.out.println(response.getRequestId());


        } catch (TencentCloudSDKException e) {
            e.printStackTrace();
        }
    }
}
