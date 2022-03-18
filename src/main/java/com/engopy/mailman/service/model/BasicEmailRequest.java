package com.engopy.mailman.service.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class BasicEmailRequest {

    private String emailTo;
    private String subject;
    private String message;

}
