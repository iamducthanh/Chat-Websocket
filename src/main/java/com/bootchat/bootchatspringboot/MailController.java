package com.bootchat.bootchatspringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;

@RestController
public class MailController {
    @Autowired
    private MailerUtil mailerUtil;

    @PostMapping("/mail/send")
    @CrossOrigin("*")
    public String sendMail(@RequestBody MailPojo mailPojo) {
        try{
            mailerUtil.send(mailPojo);
        } catch (Exception e){
            return "Lỗi cmnr!";
        }
        return "Gửi thành công";
    }
}
