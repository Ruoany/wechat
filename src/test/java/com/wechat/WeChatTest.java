package com.wechat;

import com.alibaba.fastjson.JSONObject;
import com.baidu.aip.ocr.AipOcr;
import com.thoughtworks.xstream.XStream;
import com.wechat.entity.development.*;
import com.wechat.entity.messages.*;
import com.wechat.utils.AccessTokenUtils;
import com.wechat.utils.GetUserInfo;
import org.json.JSONException;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 若安择晴
 * @description WeChatTest
 * @date 2020/4/19--17:14
 */
public class WeChatTest {

    //设置APPID/AK/SK百度ocr识别
    public static final String APP_ID = "19507686";
    public static final String API_KEY = "xqeSlwQl9PtrcGNyHXnyyIk9";
    public static final String SECRET_KEY = "VEHkoivsCZSo6mfYUifeWd7DSfuABZa6";


    @Test
    public void testToken(){
       System.out.println(AccessTokenUtils.getAccessToken());
    }

    @Test
    public void testButton(){
        //菜单对象
        Button button=new Button();
        //第一个一级菜单
        button.getButton().add(new ClickButton("一级菜单1","1"));
        //第二个一级菜单
        button.getButton().add(new ViewButton("一级菜单2","http://www.baidu.com"));
        //第三个一级菜单
        SubButton subButton=new SubButton("一级菜单3，有子菜单");
        //第三个一级菜单的子菜单
        subButton.getSub_button().add(new PhotoOrAlbumButton("传图","3_1"));
        subButton.getSub_button().add(new ClickButton("点击","32"));
        subButton.getSub_button().add(new ViewButton("网易新闻","http://www.news.163.com"));
        //加入第三个一级菜单
        button.getButton().add(subButton);


      JSONObject jsonObject= (JSONObject) JSONObject.toJSON(button);
      System.out.println(jsonObject.toString());
    }



    @Test
    public void baiduocr() throws JSONException {
        // 初始化一个AipOcr
        AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
       // client.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
        //client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理

        // 可选：设置log4j日志输出格式，若不设置，则使用默认配置
        // 也可以直接通过jvm启动参数设置此环境变量
        //System.setProperty("aip.log4j.conf", "path/to/your/log4j.properties");

        // 调用接口
        String path = "E:\\Code\\Intellij IDEA\\wechat_1\\src\\main\\resources\\m2.png";
        org.json.JSONObject res = client.basicGeneral(path, new HashMap<String, String>());
        System.out.println(res.toString(2));
    }



    @Test
    public void testMsg(){
        Map<String,String> map=new HashMap<>();
        map.put("ToUserName","to");
        map.put("FromUserName","from");
        map.put("MsgType","type");
        TextMessage textMessage=new TextMessage(map,"还好");
        System.out.println(textMessage);

        XStream stream=new XStream();
        stream.processAnnotations(TextMessage.class);
        stream.processAnnotations(ImageMessage.class);
        stream.processAnnotations(MusicMessage.class);
        stream.processAnnotations(NewsMessage.class);
        stream.processAnnotations(VideoMessage.class);
        stream.processAnnotations(VoiceMessage.class);
        String xml=stream.toXML(textMessage);
        System.out.println(xml);
    }


    @Test
    public void getUserInfo(){
        String url="o5UuvwDmjm0hYkpd_zmi4aRbRp10";
       String info= GetUserInfo.getUserInfo(url);
        System.out.println(info);
    }

    @Test
    public void getWeather(){
        String url="https://tianqiapi.com/api?version=v61&appid=91537794&appsecret=Jao6sphc&city=常德";
       String str= AccessTokenUtils.getRequest(url);
       JSONObject jsonObject=JSONObject.parseObject(str);
        System.out.println(jsonObject);

    }


}
