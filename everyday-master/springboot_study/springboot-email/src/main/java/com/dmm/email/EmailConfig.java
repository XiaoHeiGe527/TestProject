package com.dmm.email;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author DMM
 * @create 2019/9/23
 */
@Component
public class EmailConfig {

    @Value("${spring.mail.username}")
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}

