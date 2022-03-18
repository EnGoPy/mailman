package com.engopy.mailman.service;

import com.engopy.mailman.service.model.EmailRequest;

public interface EmailService {
    void sendEmail(EmailRequest emailRequest);
}
