package com.engopy.mailman.service.model;

import lombok.Getter;

import java.util.Map;

@Getter
public class TemplateEmailRequest {

    private String emailTo;
    private String subject;
    private Map<String, String> parameters;
    private String template;
}
