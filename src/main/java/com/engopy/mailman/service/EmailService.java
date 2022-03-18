package com.engopy.mailman.service;

import com.engopy.mailman.service.model.BasicEmailRequest;
import com.engopy.mailman.service.model.TemplateEmailRequest;

public interface EmailService {
    void sendEmail(BasicEmailRequest emailRequest);
    void sendEmail(TemplateEmailRequest templateEmailRequest);
}
