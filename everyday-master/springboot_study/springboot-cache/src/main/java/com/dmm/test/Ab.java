package com.dmm.test;

import java.net.URLEncoder;

/**
 * @author DMM
 * @create 2019/8/20
 */

public class Ab {

    public static void main(String[] args) {

        String appId="wx2402a285f9fe3ca3";
        String redirectUri="http://clbdev.yunzhiqu.com/weChat/getOpenid";

        String url = "https://open.weixin.qq.com/connect/qrconnect?appid="+appId
                +"&redirect_uri="+ URLEncoder.encode(redirectUri)
                +"&response_type=code"
                +"&scope=snsapi_login&state=STATE#wechat_redirect";

        System.out.println(url);
    }
}

