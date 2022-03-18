package com.engopy.mailman.service.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class EmailRequest {

    private String emailTo;
    private String subject;
    private String message;

}
