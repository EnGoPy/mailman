package com.engopy.mailman.api;

import com.engopy.mailman.api.validation.EmailMessageValidation;
import com.engopy.mailman.api.validation.EmailSubjectValidation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TemplateEmailRequestApi {

    @Email
    private String emailTo;
    @EmailSubjectValidation
    private String subject;
    @NotEmpty
    private Map<String, String> parameters;
    @EmailMessageValidation
    private String template;
}
