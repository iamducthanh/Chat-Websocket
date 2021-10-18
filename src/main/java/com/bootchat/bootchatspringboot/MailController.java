package com.bootchat.bootchatspringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;

@Controller
public class MailController {
    @Autowired
    private MailerUtil mailerUtil;

    @GetMapping("/get-ip")
    @ResponseBody
    public String sendMail(@RequestBody MailPojo mailPojo) {
        try{
            mailerUtil.send(mailPojo);
        } catch (Exception e){
            return "Lỗi cmnr!";
        }
        return "Gửi thành công";
    }
}
