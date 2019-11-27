package com.dmm.controller;

import com.dmm.email.service.EmailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;

/**
 * @author DMM
 * @create 2019/9/25
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EmailControllerTest {

    @Autowired
    private EmailService emailService;

    @Test
    public void testSend(){
        emailService.sendSimpleMail("dumm@yunzhiqu.com","杜明明","杜明明---+++");
    }
    @Test
    public void testAttachmentSend(){
        emailService.sendAttachmentMail("dumm@yunzhiqu.com","杜明明","杜明明---+++",new File("C:\\Users\\dmm\\Desktop\\转正.txt"));
    }

    @Test
    public void testTemplateSend(){
        emailService.sendTemplateMail("dumm@yunzhiqu.com","杜明明","info.html");
    }
}

