package com.wechat.entity.messages;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.wechat.entity.messagetype.Articles;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author 若安择晴
 * @description ImageTextMessage
 * @date 2020/4/19--16:52
 */
@Data
@XStreamAlias("xml")
public class NewsMessage extends BaseMessage {

    @XStreamAlias("ArticleCount")
    private String articleCount;
    @XStreamAlias("Articles")
    private List<Articles> articles=new ArrayList<>();

    public NewsMessage(Map<String,String> requestMap,List<Articles> articles){
        super(requestMap);
        this.setMsgType("news");
        this.articleCount=articles.size()+"";
        this.articles=articles;
    }


}
