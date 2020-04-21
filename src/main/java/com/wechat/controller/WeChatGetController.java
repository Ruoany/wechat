package com.wechat.controller;

import com.wechat.utils.WeChatVerificationUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author 若安择晴
 * @description WeChatGetController
 * @date 2020/4/19--21:06
 */
@RestController
@RequestMapping("/")
public class WeChatGetController {

    /**
     * 微信开发者接入验证
     * */
    @GetMapping
    public void access(HttpServletRequest request, HttpServletResponse response) throws IOException {

        /**
         * 参数	描述
         * signature	微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数。
         * timestamp	时间戳
         * nonce	随机数
         * echostr	随机字符串
         */

        String signature = request.getParameter("signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        String echostr = request.getParameter("echostr");

        //校验证请求
        if(WeChatVerificationUtils.check(timestamp,nonce,signature)){
            System.out.println("接入成功");
            PrintWriter out =response.getWriter();
            //原样返回echostr参数
            out.print(echostr);
            out.flush();
            out.close();
        }else {
            System.out.println("接入失败");
        }

    }

}
