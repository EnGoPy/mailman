package com.engopy.mailman.api.validation;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@NotBlank(message = "Message must contain something")
@Length(min=1, max=500, message = "Email message must be in length range between 1 and 500")
public @interface EmailMessageValidation {
}
