package com.fc.Test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@SpringBootTest
public class MailTest {
    @Autowired
    //java自带的邮件发送器
  private  JavaMailSender  javaMailSender;
    @Test
    //测试复杂邮件类型 可以写html图片
    void testHtmlMail(){
        String content="<img src='https://t7.baidu.com/it/u=1595072465,3644073269&fm=193&f=GIF'alt='图片'>"+
                "<font align='center' color='red'>"+
                "拂衣去城市，信步踏晴泥"+
                "</font>";
        //复杂邮件类型
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        //复杂邮件处理器
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
        //
        try {
            mimeMessageHelper.setFrom("2559265773@qq.com");

            mimeMessageHelper.setTo(new String[]{
                    "1376055937@qq.com","2922860447@qq.com"
            });
            mimeMessageHelper.setCc("17633597418@qq.com");
            mimeMessageHelper.setBcc("2559265773@qq.com");
            mimeMessageHelper.setSubject("哈哈");
            mimeMessageHelper.setText(content,true); //如果false就无法识别html标签
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        javaMailSender.send(mimeMessage);
    }

    @Test
    void testSimple(){
        //创建一个简单的邮件对象
        SimpleMailMessage message = new SimpleMailMessage();

        //设置邮件的发送人
        message.setFrom("2559265773@qq.com");

        //设置邮件接受者
        message.setTo("1376055937@qq.com");

        //设置邮件主题
        message.setSubject("嘿嘿");

        //设置内容
        message.setText("你好，我是秦始皇，其实我并没有死！我在西安有 100 亿吨黄金，我现在只需 100 元人民币来解冻我在西安的黄金！你微信、支付宝转给我都可以，账号就是我的手机号！转过来我直接带兵打过去，让你统领三军！");

        //设置抄送人
        message.setCc("2559265773@qq.com");

        //设置秘密抄送

        message.setBcc("2559265773@qq.com");
        //发送邮件

//        for (int i=0;i<10;i++){
            javaMailSender.send(message);
//        }


    }
}
