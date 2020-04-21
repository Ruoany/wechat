package com.wechat.entity.development;

import lombok.Data;

/**
 * @author 若安择晴
 * @description AccessToken
 * @date 2020/4/20--8:36
 */
@Data
public class AccessToken {


    private String accessToken;
    private long expiresTime;

    public AccessToken(String accessToken,String expiresIn){
         super();
         this.accessToken=accessToken;
         expiresTime=System.currentTimeMillis()+Integer.parseInt(expiresIn)*1000;
    }

    /**
     * 判断token是否过期
     * */
    public boolean isExpired(){
        return System.currentTimeMillis()>expiresTime;
    }

}
