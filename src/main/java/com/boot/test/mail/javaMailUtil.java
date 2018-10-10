package com.boot.test.mail;

import com.sun.org.apache.bcel.internal.generic.NEW;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;



public class javaMailUtil {

   private Properties properties = new Properties();
   private String username;
   private String password;
    /**
     * 初始化方法
     */
   public void init()throws Exception{
       //设置连接服务器
//       properties.put("mail.host","mail.zealfi.com");
       //设置是否验证
       properties.put("mail.smtp.auth","true");
       // 设置通信协议
       properties.put("mail.transport.protocol", "smtp");

//       this.base64Encode();
    /*   //声明用户名和密码
       Authenticator auth = new Authenticator() {
           @Override
           protected PasswordAuthentication getPasswordAuthentication() {
               PasswordAuthentication pwd =
                       new PasswordAuthentication(username, password);
               return pwd;
           }
       };*/

       Session session = Session.getInstance(properties);
       session.setDebug(true);

       //声明邮件内容
       MimeMessage msg = new MimeMessage(session);
       Address form = new InternetAddress("fanxiaozhu@zealfi.com");
       msg.setFrom(form);
//       msg.setRecipient(Message.RecipientType.TO,new InternetAddress("linlimin@zealfi.com"));
       msg.setSubject("测试邮件");
       msg.setContent("你好,这是一封Test邮件","text/plain;charset=UTF-8");

       //发送
       // 邮件传输对象
       Transport transport = session.getTransport();
       // 传输连接：host，port，user，pass/主机，端口，用户名，密码
       transport.connect("mail.zealfi.com", 25, "fanxiaozhu@zealfi.com", "Fanxiaozhu1314");
       // 发送邮件
       transport.sendMessage(msg, new Address[] { new InternetAddress("linlimin@zealfi.com") });
       // 关闭连接
       transport.close();
   }

   public void base64Encode(){
       String name = "fanxiaozhu@zealfi.com";
       String pwd = "Fanxiaozhu1314";
       BASE64Encoder en = new BASE64Encoder();
       username = en.encode(name.getBytes());
       password = en.encode(pwd.getBytes());
       System.err.println(username);
       System.err.println(password);

   }
   public static void main(String[] args)throws Exception{
       BASE64Decoder d = new BASE64Decoder();
       System.err.println(d.decodeBuffer("UGFzc3dvcmQ6"));
    }
}
