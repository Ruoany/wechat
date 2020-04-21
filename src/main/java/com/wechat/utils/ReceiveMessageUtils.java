package com.wechat.utils;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 若安择晴
 * @description MessageEvent  接收用户消息工具类
 * @date 2020/4/19--11:16
 */
public class ReceiveMessageUtils {

    /**
     * 解析xml数据包
     * @param is
     * @return
     * */
    public static Map<String,String> parseRequest(InputStream is){

        Map<String,String> map=new HashMap<String,String>(16);
        SAXReader reader=new SAXReader();
        try {
            //读取数据流，拿到文档对象
            Document document=reader.read(is);
            //根据文档对象拿到根节点
            Element root=document.getRootElement();
            //获取根节点下面的所有子节点
            List<Element> elements=root.elements();
            for(Element e:elements){
                map.put(e.getName(),e.getStringValue());
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return map;
    }
}
