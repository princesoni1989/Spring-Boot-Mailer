package com.springboot.mail.controller;

import com.springboot.mail.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class Mailer {

    @Autowired
    private MailService mailService;

    @PostMapping("/sendmail")
    public String uploadFile(@RequestParam("email") String email) {
        System.out.println("emailid"+ email);
        mailService.send(email);
        return "Mail Sent successfully";
    }
}
