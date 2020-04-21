package com.wechat.entity.messagetype;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

/**
 * @author 若安择晴
 * @description Voice
 * @date 2020/4/19--16:47
 */
@Data
@XStreamAlias("Voice")
public class Voice {

    @XStreamAlias("MediaId")
    private  String mediaId;

    public Voice(String mediaId){
        super();
        this.mediaId=mediaId;
    }

}
