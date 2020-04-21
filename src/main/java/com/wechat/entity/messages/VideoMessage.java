package com.wechat.entity.messages;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.wechat.entity.messagetype.Video;
import lombok.Data;

import java.util.Map;

/**
 * @author 若安择晴
 * @description VideoMessage
 * @date 2020/4/19--15:36
 */
@Data
@XStreamAlias("xml")
public class VideoMessage extends BaseMessage {

   private Video video;

    public VideoMessage(Map<String,String> requestMap,Video video){
        super(requestMap);
        this.setMsgType("video");
        this.video=video;
    }
}
