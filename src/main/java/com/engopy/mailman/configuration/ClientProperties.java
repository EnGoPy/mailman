package com.engopy.mailman.configuration;


import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Getter
@NoArgsConstructor
public class ClientProperties {

    @Value("${email.address:empty}")
    private String email;

    @Value("${email.name:Work Checker}")
    private String fromName;

    @Value("${email.password:empty}")
    private String password;

    @Value("${email.smtp.server:empty}")
    private String smtp_server;

    @Value("${email.smtp.port:1111}")
    private Integer smtp_port;

    @Value("${email.smtp.auth:empty}")
    private String smtp_auth;

    @Value("${email.smtp.starttls.required:true}")
    private Boolean startTlsRequired;

    @Value("${email.smtp.starttls.enable:true}")
    private Boolean startTlsEnabled;

    @Value("${email.transport.protocol:empty}")
    private String transportProtocol;

    @Value("${email.smtp.ssl.enable:true}")
    private String smtpSslEnable;

    @Value("${email.debug:false}")
    private String emailDebug;

    public Map<String, Object> getClientProperties(){
        Map<String, Object> emailProperties = new HashMap<>();
        emailProperties.put("email", email);
        emailProperties.put("fromName", fromName);
        emailProperties.put("password", "*** protected");
        emailProperties.put("smtp_server", smtp_server);
        emailProperties.put("smtp_port", smtp_port);
        emailProperties.put("smtp_auth", smtp_auth);
        emailProperties.put("startTlsRequired", startTlsRequired);
        emailProperties.put("startTlsEnabled", startTlsEnabled);
        emailProperties.put("transportProtocol", transportProtocol);
        emailProperties.put("smtpSslEnable", smtpSslEnable);
        emailProperties.put("emailDebug", emailDebug);
        return emailProperties;
    }
}
