package com.bootchat.bootchatspringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ChatController {
    @Autowired
    HttpServletRequest req;

    String room;

    @RequestMapping("/chat")
    public String index(Model model){
        String room = req.getParameter("room");
        model.addAttribute("room",room);
        return "index";
    }

    @MessageMapping("/chat.sendMessage/{room}") // nhận 1 messenge gửi tới từ client, nhận đc thì method send đc kích hoạt
    @SendTo("/topic/{room}")
    public ChatMessagePojo sendMessage(@Payload ChatMessagePojo chatMessagePojo) {
        // khởi tạo đối tượng chat rồi gửi về slient giống onmessage send to /topic/public
        return chatMessagePojo;
    }

    @MessageMapping("/chat.addUser/{room}")
    @SendTo("/topic/{room}")
    public ChatMessagePojo addUser(@Payload ChatMessagePojo chatMessagePojo, SimpMessageHeaderAccessor headerAccessor) {
// Add username in web socket session
        headerAccessor.getSessionAttributes().put("username", chatMessagePojo.getSender());
        headerAccessor.getSessionAttributes().put("room", chatMessagePojo.getRoom());
        return chatMessagePojo;
    }
}