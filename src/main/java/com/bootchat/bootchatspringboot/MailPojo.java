package com.bootchat.bootchatspringboot;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MailPojo {
    private String from;
    private String to;
    private String subject;
    private String body;
}
