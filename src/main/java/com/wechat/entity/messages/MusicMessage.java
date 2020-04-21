package com.wechat.entity.messages;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.wechat.entity.messagetype.Music;
import lombok.Data;

import java.util.Map;

/**
 * @author 若安择晴
 * @description MusicMessage
 * @date 2020/4/19--16:17
 */
@Data
@XStreamAlias("xml")
public class MusicMessage extends BaseMessage {

   private Music music;

   public MusicMessage(Map<String, String> requestMap,Music music){
       super(requestMap);
       this.setMsgType("music");
       this.music=music;
   }
}
