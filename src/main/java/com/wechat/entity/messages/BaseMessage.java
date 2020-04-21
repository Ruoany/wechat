package com.wechat.entity.messages;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

import java.util.Map;

/**
 * @author 若安择晴
 * @description BaseMessage
 * @date 2020/4/19--13:32
 */
@Data
@XStreamAlias("xml")
public class BaseMessage {

    @XStreamAlias("ToUserName")
    private String toUserName;
    @XStreamAlias("FromUserName")
    private String fromUserName;
    @XStreamAlias("CreateTime")
    private long createTime;
    @XStreamAlias("MsgType")
    private String msgType;


    public BaseMessage(Map<String,String> requestMap){
             this.toUserName=requestMap.get("FromUserName");
             this.fromUserName=requestMap.get("ToUserName");
             this.createTime=System.currentTimeMillis()/1000;
    }
}
