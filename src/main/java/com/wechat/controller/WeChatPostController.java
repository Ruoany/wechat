package com.wechat.controller;

import com.wechat.utils.ReceiveMessageUtils;
import com.wechat.utils.ReplyMessageUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * @author 若安择晴
 * @description WeChatController
 * @date 2020/4/19--7:16
 */

@RestController
@RequestMapping("/")
public class WeChatPostController {
    /**
     * 当普通微信用户向公众账号发消息时，微信服务器将POST消息的XML数据包到开发者填写的URL上。
     * 处理用户信息与事件
     * */
    @PostMapping
    public void receive(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf8");
        response.setCharacterEncoding("utf8");

        //接收用户消息
        Map<String,String> requestMap= ReceiveMessageUtils.parseRequest(request.getInputStream());
        System.out.println(requestMap);

        //回复用户消息
        String respXml= ReplyMessageUtils.getRepose(requestMap);

        PrintWriter out =response.getWriter();
        out.print(respXml);
        out.flush();
        out.close();

    }
}
