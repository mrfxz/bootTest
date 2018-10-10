package com.boot.test.mail;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
import javax.mail.*;
import javax.mail.Address;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;


public class javaMailUtil2 {

   private Properties properties = new Properties();
   private String username = "fanxiaozhu@zealfi.com";
   private String password = "Fanxiaozhu1314";
    /**
     * 初始化方法
     */
   public void init()throws Exception{
       //设置连接服务器
       properties.put("mail.host","mail.zealfi.com");
       //设置是否验证
       properties.put("mail.smtp.auth","true");
       // 设置通信协议
       properties.put("mail.transport.protocol", "smtp");


       //声明用户名和密码
       Authenticator auth = new Authenticator() {
           @Override
           protected PasswordAuthentication getPasswordAuthentication() {
               PasswordAuthentication pwd =
                       new PasswordAuthentication(username, password);
               return pwd;
           }
       };

       Session session = Session.getInstance(properties,auth);
       session.setDebug(true);

       //声明邮件内容
       MimeMessage msg = new MimeMessage(session);
       Address form = new InternetAddress("fanxiaozhu@zealfi.com");
       msg.setFrom(form);
       msg.setRecipient(Message.RecipientType.TO,new InternetAddress("fanxiaozhu@zealfi.com"));
       msg.setSubject("测试邮件");
       msg.setContent("你好,这邮件","text/plain;charset=UTF-8");

       //发送
        Transport.send(msg);

   }


}
