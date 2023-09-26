package com.gxa.boot338.util;



import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;

import java.util.Random;

/**
 * @author bill
 * @date 2023/2/13 11:18
 */
public class SMSUtil {
    //产品名称:云通信短信API产品,开发者无需替换
    static final String product = "Dysmsapi";
    //产品域名,开发者无需替换
    static final String domain = "dysmsapi.aliyuncs.com";
    // TODO 此处需要替换成开发者自己的AK(在阿里云访问控制台寻找)
    static final String accessKeyId = "LTAI5tGSEWzS9RM8EjC2w8bK";
    static final String accessKeySecret = "IaTDtee5wde5RLvl3qIEXBZxbcMPOm";

    // 签名
    static final String sign = "小溪商城";
    /*
    * mobile 手机号
    * templateRarm 模板code:SMS_287695056
    * 模板内容
    * */
    public static SendSmsResponse sendSms(String mobile, String templateCode, String templateParam) throws ClientException {
//可自助调整超时时间
        System.setProperty("sun.net.client.defaultConnectTimeout",
                "10000");
        System.setProperty("sun.net.client.defaultReadTimeout",
                "10000");
//初始化acsClient,暂不支持region化
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou",product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);
//组装请求对象-具体描述见控制台-文档部分内容
        SendSmsRequest request = new SendSmsRequest();
//必填:待发送手机号
        request.setPhoneNumbers(mobile);
//必填:短信签名-可在短信控制台中找到
        request.setSignName(sign);
//必填:短信模板-可在短信控制台中找到
        request.setTemplateCode(templateCode);
//可选:模板中的变量替换JSON串,如模板内容为"尊敬的${name},您的验证码为${code}"时,此处的值为

       // String templateParam = "{\"code\":\"1234\"}";
        request.setTemplateParam(templateParam);
//hint 此处可能会抛出异常，注意catch
        SendSmsResponse sendSmsResponse =
                acsClient.getAcsResponse(request);
        return sendSmsResponse;
    }

    /**
     * 生成随机的4位数，短信验证码
     * @return
     */
    public static String getMsgCode() {
        int n = 4;
        StringBuilder code = new StringBuilder();
        Random ran = new Random();
        for (int i = 0; i < n; i++) {
            code.append(Integer.valueOf(ran.nextInt(10)).toString());
        }
        return code.toString();
    }

}
