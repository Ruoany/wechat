package com.wechat.entity.messages;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.wechat.entity.messagetype.Image;
import lombok.Data;

import java.util.Map;

/**
 * @author 若安择晴
 * @description ImageMessage
 * @date 2020/4/19--15:26
 */
@Data
@XStreamAlias("xml")
public class ImageMessage extends BaseMessage {

    private Image image;

    public ImageMessage(Map<String,String> requestMap, Image image){
        super(requestMap);
        this.setMsgType("image");
        this.image=image;
    }
}
