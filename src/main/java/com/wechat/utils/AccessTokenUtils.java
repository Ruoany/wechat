package com.wechat.utils;

import com.alibaba.fastjson.JSONObject;
import com.wechat.entity.development.AccessToken;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author 若安择晴
 * @description AccessToken
 * @date 2020/4/20--8:01
 */
public class AccessTokenUtils {

    private static final String GET_TOKEN_URL="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
    private static final String APPID="wx54d0e8330c90d50a";
    private static final String APPSECRET="5ad069639d1be0eadf1572ce677022fd";
    //存放AccessToken
    private static AccessToken accessToken;

    /**
     * 获取access_token
     * */
     private static void getAccessToken_1(){
        String url=GET_TOKEN_URL.replace("APPID",APPID).replace("APPSECRET",APPSECRET);
        String tokenStr=getRequest(url);
        JSONObject jsonObject=JSONObject.parseObject(tokenStr);
        String token=jsonObject.getString("access_token");
        String expiresIn=jsonObject.getString("expires_in");
        //创建AccessToken对象
        accessToken=new AccessToken(token,expiresIn);
    }

    /**
     *向外暴露拿到access_token的方法
     * */
    public static String getAccessToken(){
        if (accessToken==null || accessToken.isExpired()){
            getAccessToken_1();
        }
        return accessToken.getAccessToken();
    }


    /**
     * 向指定地址发送get请求
     * */
    public static String getRequest(String url){

        try {
            URL urlObj=new URL(url);
       URLConnection connection= urlObj.openConnection();
      InputStream inputStream= connection.getInputStream();
            byte[] bytes=new byte[1024];
            int len;
            StringBuilder stringBuilder=new StringBuilder();
            while ((len=inputStream.read(bytes))!=-1){
                     stringBuilder.append(new String(bytes,0,len));
            }
            return stringBuilder.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
