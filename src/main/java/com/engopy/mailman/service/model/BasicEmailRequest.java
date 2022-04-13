package com.engopy.mailman.service.model;

import lombok.Getter;

@Getter
public class BasicEmailRequest {

    private String emailTo;
    private String subject;
    private String message;

}
