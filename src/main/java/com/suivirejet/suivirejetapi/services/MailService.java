package com.suivirejet.suivirejetapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class MailService {

    @Autowired
    private JavaMailSender javaMailSender ;

    public String sendMail(String to, String subject, String body){
        SimpleMailMessage message = new SimpleMailMessage() ;

        message.setFrom("ammr.nouhas@gmail.com");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);

        javaMailSender.send(message);
        return "Mail bien envoyé" ;
    }

    public String sendMailEmailWithAttachement(String sendFrom, String sendTo, String subject, String body, String filePath){
        try {
            MimeMessage message = javaMailSender.createMimeMessage() ;

            MimeMessageHelper messageHelper =
                    new MimeMessageHelper(message,true) ;

            messageHelper.setFrom(sendFrom);
            messageHelper.setTo(sendTo);
            messageHelper.setSubject(subject);
            messageHelper.setText(body);

            File file = new File(filePath) ;

            messageHelper.addAttachment(file.getName(),file);

            javaMailSender.send(message);
            return "Mail bien envoyé" ;

        }catch (Exception e){
            return e.getMessage() ;
        }
    }
}
