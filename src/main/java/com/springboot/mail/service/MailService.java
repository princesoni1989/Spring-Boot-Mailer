package com.springboot.mail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.internet.MimeMessage;

@Service
public class MailService {

    @Autowired
    private JavaMailSender sender;

    public void send(String toUser) {
        try {
            MimeMessage mimeMessage = sender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
            helper.setTo(toUser.toString());
            helper.setSubject("Account Created successfully");
            helper.setText("Congratulations your are part of successfull organization \n Please click on below link to activate your account");
            sender.send(mimeMessage);
        } catch (Exception e) {
            throw new RuntimeException("Error sending mail" + e);
        }

    }

}
