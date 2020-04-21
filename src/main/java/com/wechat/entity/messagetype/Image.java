package com.wechat.entity.messagetype;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

/**
 * @author 若安择晴
 * @description Image
 * @date 2020/4/19--16:44
 */
@Data
@XStreamAlias("Image")
public class Image {

    @XStreamAlias("MediaId")
    private String mediaId;
    @XStreamAlias("PicUrl")
    private String picUrl;


    public Image(String mediaId, String picUrl){
        super();
        this.mediaId=mediaId;
        this.picUrl=picUrl;
    }

}
