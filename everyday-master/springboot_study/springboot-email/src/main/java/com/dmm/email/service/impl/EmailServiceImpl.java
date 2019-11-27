package com.dmm.email.service.impl;

import com.dmm.email.EmailConfig;
import com.dmm.email.service.EmailService;
import freemarker.template.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * @author DMM
 * @create 2019/9/23
 */
@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private EmailConfig emailConfig;

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private FreeMarkerConfigurer freeMarkerConfigurer;

    @Override
    public void sendSimpleMail(String sendTo,String title,String content) {

        //简单右键的发送
        SimpleMailMessage simpleMailMessage=new SimpleMailMessage();

        simpleMailMessage.setFrom(emailConfig.getUserName());
        simpleMailMessage.setTo(sendTo);
        simpleMailMessage.setSubject(title);
        simpleMailMessage.setText(content);
        simpleMailMessage.setBcc();

        javaMailSender.send(simpleMailMessage);

    }

    @Override
    public void sendAttachmentMail(String sendTo, String title, String content, File file) {
        MimeMessage mimeMessage=javaMailSender.createMimeMessage();

        try {
            MimeMessageHelper mimeMessageHelper=new MimeMessageHelper(mimeMessage,true);

            mimeMessageHelper.setFrom(emailConfig.getUserName());
            mimeMessageHelper.setTo(sendTo);
            mimeMessageHelper.setSubject(title);
            mimeMessageHelper.setText(content);
            FileSystemResource fileSystemResource=new FileSystemResource(file);

            mimeMessageHelper.addAttachment(file.getName(),fileSystemResource);

        } catch (MessagingException e) {
            e.printStackTrace();
        }

        javaMailSender.send(mimeMessage);

    }

    @Override
    public void sendTemplateMail(String sendTo, String title, String info) {

        MimeMessage mimeMessage=javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper mimeMessageHelper=new MimeMessageHelper(mimeMessage,true);

            mimeMessageHelper.setFrom(emailConfig.getUserName());
            mimeMessageHelper.setTo(sendTo);
            mimeMessageHelper.setSubject(title);
            Map<String,Object> map=new HashMap<>();

            map.put("userName","杜明明");

            Template template=freeMarkerConfigurer.getConfiguration().getTemplate(info);

            String html=FreeMarkerTemplateUtils.processTemplateIntoString(template,map);
            mimeMessageHelper.setText(html);

        }catch (Exception e){
            e.printStackTrace();
        }
        javaMailSender.send(mimeMessage);
    }
}

