package com.fc.controller;

import com.fc.vo.MailVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Date;

@RestController
@RequestMapping("mail")
public class MailController {
    @Autowired
    private JavaMailSender sender;

    @RequestMapping("send")
    public String send(MailVO vo, MultipartFile[] file) throws MessagingException {
        //复杂邮件的消息对象
        MimeMessage mimeMessage = sender.createMimeMessage();
        //  复杂邮件处理器
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true); // 为true支持附件

        try {
            helper.setFrom(vo.getFrom());
            helper.setTo(vo.getTo());
            helper.setCc(vo.getCc());
            helper.setBcc(vo.getBcc());
            helper.setSubject(vo.getSubject());
            helper.setText(vo.getContent());
            //设置邮件发送日期
            helper.setSentDate(new Date());
            // 添加附件
            if (file.length > 0) {
                for (MultipartFile multipartFile : file) {
                    if (!multipartFile.isEmpty() && multipartFile.getOriginalFilename() != null) {
                        helper.addAttachment(multipartFile.getOriginalFilename(), multipartFile);
                    }
                }
            }


            // 发送
            sender.send(mimeMessage);

            return "发送成功！";
        } catch (MessagingException e) {
            e.printStackTrace();

            return "发送失败！";
        }
    }
}