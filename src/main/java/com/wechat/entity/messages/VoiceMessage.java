package com.wechat.entity.messages;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.wechat.entity.messagetype.Voice;
import lombok.Data;

import java.util.Map;

/**
 * @author 若安择晴
 * @description VoiceMessage
 * @date 2020/4/19--15:31
 */
@Data
@XStreamAlias("xml")
public class VoiceMessage extends BaseMessage {

    private Voice voice;

    public VoiceMessage(Map<String,String> requestMap, Voice voice){
        super(requestMap);
        this.setMsgType("voice");
        this.voice=voice;
    }
}
