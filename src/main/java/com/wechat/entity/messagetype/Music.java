package com.wechat.entity.messagetype;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

/**
 * @author 若安择晴
 * @description Music
 * @date 2020/4/19--16:40
 */
@Data
@XStreamAlias("Music")
public class Music {

    @XStreamAlias("Title")
    private String title;
    @XStreamAlias("Description")
    private String description;
    @XStreamAlias("MusicURL")
    private String musicURL;
    @XStreamAlias("HQMusicUrl")
    private String hQMusicUrl;
    @XStreamAlias("ThumbMediaId")
    private String thumbMediaId;



    public Music(String title, String description, String musicURL, String hQMusicUrl, String thumbMediaId){
        super();
        this.title=title;
        this.description=description;
        this.musicURL=musicURL;
        this.hQMusicUrl=hQMusicUrl;
        this.thumbMediaId=thumbMediaId;
    }
}
