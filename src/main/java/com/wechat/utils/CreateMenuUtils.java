package com.wechat.utils;

import com.alibaba.fastjson.JSONObject;
import com.wechat.entity.development.*;

/**
 * @author 若安择晴
 * @description CreateMenuUtils
 * @date 2020/4/20--19:24
 */
public class CreateMenuUtils {

    public static void main(String[] args) {

        //菜单对象
        Button button=new Button();
        //第一个一级菜单
        button.getButton().add(new ClickButton("一级菜单1","1"));
        //第二个一级菜单
        button.getButton().add(new ViewButton("一级菜单2","http://www.baidu.com"));
        //第三个一级菜单
        SubButton subButton=new SubButton("关于");
        //第三个一级菜单的子菜单
        subButton.getSub_button().add(new PhotoOrAlbumButton("文字识别","3_1"));
        subButton.getSub_button().add(new ClickButton("常德天气","32"));
        subButton.getSub_button().add(new ViewButton("个人博客","http://www.zeqin.xyz"));
        //加入第三个一级菜单
        button.getButton().add(subButton);

        JSONObject jsonObject= (JSONObject) JSONObject.toJSON(button);
        //准备需要发送请求的url
        String url=" https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
         url=url.replace("ACCESS_TOKEN",AccessTokenUtils.getAccessToken());
      String result= MenuPostRequestUtils.post(url,jsonObject.toString());
         System.out.println(result);
    }
}
