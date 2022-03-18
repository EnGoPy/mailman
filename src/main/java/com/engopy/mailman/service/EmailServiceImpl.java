package com.engopy.mailman.service;

import com.engopy.mailman.service.model.BasicEmailRequest;
import com.engopy.mailman.service.model.TemplateEmailRequest;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.Map;

@Service
@Slf4j
public class EmailServiceImpl implements EmailService{

    @Autowired
    JavaMailSender javaMailSender;

    @Autowired
    TemplateEngine templateEngine;

    public void sendEmail(BasicEmailRequest emailRequest) {
        MimeMessagePreparator messagePreparator = mimeMessage -> {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
            messageHelper.setTo(emailRequest.getEmailTo());
            messageHelper.setSubject(emailRequest.getSubject());
            messageHelper.setText(emailRequest.getMessage());
        };
        processSend(messagePreparator);
    }

    public void sendEmail(TemplateEmailRequest templateEmailRequest){
        MimeMessagePreparator messagePreparator = mimeMessage -> {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
            messageHelper.setTo(templateEmailRequest.getEmailTo());
            messageHelper.setSubject(templateEmailRequest.getSubject());
                messageHelper.setText(prepareWeeklyReportEmail(templateEmailRequest.getParameters(), templateEmailRequest.getTemplate()), true);
        };
        processSend(messagePreparator);
    }

    private void processSend(MimeMessagePreparator mimeMessagePreparator){
        try {
            javaMailSender.send(mimeMessagePreparator);
        } catch (Exception e){
            log.error("An error occured during email sending");
        }
    }


    private String prepareWeeklyReportEmail(Map<String, String> parameters, String template) {
        Context context = new Context();
        for(String parameter : parameters.keySet()){
            context.setVariable(parameter, parameters.get(parameter));
        }
        return templateEngine.process(template, context);
    }

}
