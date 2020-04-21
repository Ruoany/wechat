package com.wechat.utils;

/**
 * @author 若安择晴
 * @description GetUserInfo
 * @date 2020/4/21--10:51
 */
public class GetUserInfo {

    public static String getUserInfo(String openid){
        String url=" https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
        url=url.replace("ACCESS_TOKEN",AccessTokenUtils.getAccessToken()).replace("OPENID",openid);
          String result=AccessTokenUtils.getRequest(url);
          return result;
    }


}
