package com.dmm.email.comtroller;

import com.dmm.email.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author DMM
 * @create 2019/9/23
 */
@Controller
public class EmailController {

    @Autowired
    private EmailService emailService;

    @RequestMapping("/a")
    @ResponseBody
    public String sendSimpleEmail(){
        emailService.sendSimpleMail("2834203588@qq.com","","");

        return "成功";
    }
}

