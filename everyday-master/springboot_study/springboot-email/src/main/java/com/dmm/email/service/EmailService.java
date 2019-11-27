package com.dmm.email.service;

import java.io.File;

/**
 * @author DMM
 * @create 2019/9/23
 */

public interface EmailService {

    //简单发送
    void sendSimpleMail(String sendTo,String title,String content);
    //附件发送
    void sendAttachmentMail(String sendTo, String title, String content, File file);

    //发送模板
    void sendTemplateMail(String sendTo, String title, String info);
}

