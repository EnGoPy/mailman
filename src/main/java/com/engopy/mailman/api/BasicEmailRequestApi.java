package com.engopy.mailman.api;

import com.engopy.mailman.api.validation.EmailMessageValidation;
import com.engopy.mailman.api.validation.EmailSubjectValidation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BasicEmailRequestApi {

    @Email
    private String emailTo;
    @EmailSubjectValidation
    private String subject;
    @EmailMessageValidation
    private String message;
}
