package com.engopy.mailman.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;
import org.thymeleaf.templateresolver.StringTemplateResolver;

import java.util.Collections;
import java.util.Properties;

@Configuration
public class EmailConfiguration {

    @Autowired
    ClientProperties clientProperties;

    @Bean
    public JavaMailSender getJavaMailSender(){
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(clientProperties.getSmtp_server());
        mailSender.setPort(clientProperties.getSmtp_port());

        mailSender.setUsername(clientProperties.getEmail());
        mailSender.setPassword(clientProperties.getPassword());

        Properties properties = mailSender.getJavaMailProperties();
        properties.put("mail.smtp.starttls.required", clientProperties.getStartTlsRequired());
        properties.put("mail.smtp.starttls.enable", clientProperties.getStartTlsEnabled());
        properties.put("mail.smtp.auth", clientProperties.getSmtp_auth());
        properties.put("mail.ssl.enable", clientProperties.getSmtpSslEnable());
        properties.put("mail.transport.protocol", clientProperties.getTransportProtocol());
        properties.put("mail.debug", "true");
        return mailSender;
    }

}
