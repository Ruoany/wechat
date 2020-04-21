package com.wechat.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baidu.aip.ocr.AipOcr;
import com.thoughtworks.xstream.XStream;
import com.wechat.entity.messages.*;
import com.wechat.entity.messagetype.Articles;

import java.util.*;


/**
 * @author 若安择晴
 * @description ReplyMessageUtils
 * @date 2020/4/19--13:11
 */
public class ReplyMessageUtils {

    //数据聚合聊天机器人
    private static final String APPKEY="7397ec7e53e29693cf4402e1a5a4bd52";

    //设置APPID/AK/SK(百度OCR)
    public static final String APP_ID = "19507686";
    public static final String API_KEY = "xqeSlwQl9PtrcGNyHXnyyIk9";
    public static final String SECRET_KEY = "VEHkoivsCZSo6mfYUifeWd7DSfuABZa6";

    /**
     * @param requestMap
     * @return xml数据包
     * @deprecated 处理所有的事件与消息回复
     */
    public static String getRepose(Map<String, String> requestMap) {
        BaseMessage msg = null;
        String msgType = requestMap.get("MsgType");
        switch (msgType) {
            case "text":
                msg = dealTextMessage(requestMap);
                break;
            case "image":
                msg= dealImageMessage(requestMap);
                break;
            case "voice":
                break;
            case "video":
                break;
            case "shortvideo":
                break;
            case "location":
                break;
            case "link":
                break;
            case "event":
                msg=dealEvent(requestMap);
                break;
            default:
                break;
        }
        //把消息对象处理为XML数据包
        if (msg != null) {
            return beanToXml(msg);
        } else {
            return null;
        }
    }

    /**
     * 进行图片识别
     * */
    private static <jsonObject> BaseMessage dealImageMessage(Map<String, String> requestMap) {
        // 初始化一个AipOcr
        AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        // 调用接口
        String path =requestMap.get("PicUrl");
        org.json.JSONObject res =client.generalUrl(path,new HashMap<String,String>());
                String json=res.toString();
       JSONObject jsonObject=JSONObject.parseObject(json);
      JSONArray jsonArray=jsonObject.getJSONArray("words_result");
       Iterator<Object> iterator= jsonArray.iterator();
       StringBuilder stringBuilder=new StringBuilder();
        while (iterator.hasNext()){
             JSONObject next= (JSONObject) iterator.next();
               stringBuilder.append(next.getString("words"));
        }
        return new TextMessage(requestMap,stringBuilder.toString());
    }

    /**
     * 处理事件推送
     * */
    private static BaseMessage dealEvent(Map<String, String> requestMap) {
            String event=requestMap.get("Event");
            switch (event){
                case "CLICK":
                    return dealClick(requestMap);
                case "VIEW":
                    return dealView(requestMap);
                default:
                    break;

            }
            return null;
    }

    /**
     * 处理view类型按钮的菜单
     * */
    private static BaseMessage dealView(Map<String, String> requestMap) {

        return null;
    }

    /**
     * 处理click类型按钮的菜单
     * */
    private static BaseMessage dealClick(Map<String, String> requestMap) {
        String key=requestMap.get("EventKey");
        switch (key){
            case "1":
                return new TextMessage(requestMap,"你点了一下第一个一级菜单");
            case "32":
               return getWeather(requestMap);
            default:
                break;
        }
        return null;
    }

    /**
     * 本地天气
     *
     * @return*/
    private static TextMessage getWeather(Map<String, String> requestMap) {
        String url = "https://tianqiapi.com/api?version=v61&appid=91537794&appsecret=Jao6sphc&city=常德";
        String str = AccessTokenUtils.getRequest(url);
        JSONObject jsonObject = JSONObject.parseObject(str);

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(jsonObject.getString("air_tips"));
        stringBuilder.append(jsonObject.getString("date"));
        stringBuilder.append(jsonObject.getString("wea"));
        return new TextMessage(requestMap, stringBuilder.toString());

    }

    //处理文本消息
    private static BaseMessage dealTextMessage(Map<String,String> requestMap){
        String msg=requestMap.get("Content");

        if(msg.equals("长沙")){
            List<Articles> articles=new ArrayList<>();
            articles.add(new Articles("湖南长沙","湖南的省会城市","https://mmbiz.qpic.cn/mmbiz_jpg/8W9nI4nEBJUiakibvgPH3O2SRxmutvoeX8iar3AC68VzJOAeD8mPRicnY23B1ycCfTYWb5xLBALD08HzUyZmibQYTrA/0","http://www.zeqin.xyz"));
            NewsMessage nw=new NewsMessage(requestMap,articles);
             return nw;
        }

        String resp=chat(msg);

        TextMessage textMessage = new TextMessage(requestMap, resp);
        return textMessage;
    }


    //调用聊天机器人
    private static String chat(String msg) {
        String result =null;
        //请求接口地址
        String url ="http://op.juhe.cn/iRobot/index";
        //请求参数
        Map params = new HashMap();
        //您申请到的本接口专用的APPKEY
        params.put("key",APPKEY);
        //要发送给机器人的内容，不要超过30个字符
        params.put("info",msg);
        //返回的数据的格式，json或xml，默认为json
        params.put("dtype","");
        //地点，如北京中关村
        params.put("loc","");
        //经度，东经116.234632（小数点后保留6位），需要写为116234632
        params.put("lon","");
        //纬度，北纬40.234632（小数点后保留6位），需要写为40234632
        params.put("lat","");
        //1~32位，此userid针对您自己的每一个用户，用于上下文的关联
        params.put("userid","");
        try {
            result =RobotUtils.net(url, params, "GET");
            JSONObject jsonObject=JSONObject.parseObject(result);
            int code=jsonObject.getInteger("error_code");
            if(code!=0){
                return null;
            }
           String reps= jsonObject.getJSONObject("result").getString("text");
            return reps;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String beanToXml(BaseMessage msg){
        XStream stream = new XStream();
        //设置需要处理@XStreamAlias（"xml"）注解的类
        stream.processAnnotations(TextMessage.class);
        stream.processAnnotations(ImageMessage.class);
        stream.processAnnotations(MusicMessage.class);
        stream.processAnnotations(NewsMessage.class);
        stream.processAnnotations(VideoMessage.class);
        stream.processAnnotations(VoiceMessage.class);
        String xml = stream.toXML(msg);
        return xml;
    }
}
