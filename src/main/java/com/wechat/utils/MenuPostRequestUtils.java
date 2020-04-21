package com.wechat.utils;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author 若安择晴
 * @description MenuPostRequestUtils
 * @date 2020/4/20--19:29
 */
public class MenuPostRequestUtils {

    /**
     * 向指定的地址发送post请求，并带有数据
     *
     * @return*/
     public static String post(String url, String data) {
         try {
             URL urlObj = new URL(url);
             URLConnection connection = urlObj.openConnection();
             //设置为可发送数据
             connection.setDoOutput(true);
             //获取输出流
             OutputStream outputStream = connection.getOutputStream();
             //写出数据
             outputStream.write(data.getBytes());
             outputStream.close();

             InputStream inputStream= connection.getInputStream();
             byte[] bytes=new byte[1024];
             int len;
             StringBuilder stringBuilder=new StringBuilder();
             while ((len=inputStream.read(bytes))!=-1){
                 stringBuilder.append(new String(bytes,0,len));
             }
             return stringBuilder.toString();
         } catch (Exception e) {
             e.printStackTrace();
         }
         return null;
     }

}
