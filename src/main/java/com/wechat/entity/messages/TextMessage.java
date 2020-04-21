package com.wechat.entity.messages;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

import java.util.Map;

/**
 * @author 若安择晴
 * @description TextMessage
 * @date 2020/4/19--13:41
 */
@Data
@XStreamAlias("xml")
public class TextMessage extends BaseMessage {

    @XStreamAlias("Content")
    private String content;

    public TextMessage(Map<String,String> requestMap, String content){
        super(requestMap);
        this.setMsgType("text");
        this.content=content;
    }

    @Override
    public String toString() {
        return "TextMessage{" +
                "content='" + content + '\'' +
                '}';
    }
}
