package com.bootchat.bootchatspringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;

@Controller
public class MailController {
    @Autowired
    private MailerUtil mailerUtil;

    @GetMapping("/mail/send")
    @CrossOrigin("*")
    @ResponseBody
    public String sendMail(
            @RequestParam("from") String from,
            @RequestParam("to") String to,
            @RequestParam("subject") String subject,
            @RequestParam("body") String body
    ) {
        try{
            MailPojo mailPojo = new MailPojo(from, to, subject, body);
            mailerUtil.send(mailPojo);
        } catch (Exception e){
            return "Lỗi cmnr!";
        }
        return "Gửi thành công";
    }
}
