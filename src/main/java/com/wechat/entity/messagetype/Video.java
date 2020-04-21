package com.wechat.entity.messagetype;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

/**
 * @author 若安择晴
 * @description Video
 * @date 2020/4/19--16:49
 */
@Data
@XStreamAlias("Video")
public class Video {

    @XStreamAlias("MediaId")
    private String mediaId;
    @XStreamAlias("Title")
    private String title;
    @XStreamAlias("Description")
    private String description;

    public Video( String mediaId, String title, String description){
        super();
        this.mediaId=mediaId;
        this.title=title;
        this.description=description;
    }
}
