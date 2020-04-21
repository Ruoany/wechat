package com.wechat.entity.messagetype;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

/**
 * @author 若安择晴
 * @description ImageText
 * @date 2020/4/19--16:51
 */
@Data
@XStreamAlias("item")
public class Articles {

     @XStreamAlias("Title")
     private String title;
     @XStreamAlias("Description")
     private String description;
     @XStreamAlias("PicUrl")
     private String picUrl;
     @XStreamAlias("Url")
     private String url;

     public Articles(String title,String description,String picUrl,String url){
         super();
         this.title=title;
         this.description=description;
         this.picUrl=picUrl;
         this.url=url;
     }
}
