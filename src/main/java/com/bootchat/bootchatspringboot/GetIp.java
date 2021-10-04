package com.bootchat.bootchatspringboot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.net.Inet4Address;
import java.net.UnknownHostException;

@Controller
public class GetIp {
    @GetMapping("/get-ip")
    public String getIp(Model model) throws UnknownHostException {
        model.addAttribute("ip", Inet4Address.getLocalHost().getHostAddress());
        return "ip";
    }
}
