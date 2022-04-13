package com.engopy.mailman.web;

import com.engopy.mailman.api.BasicEmailRequestApi;
import com.engopy.mailman.api.TemplateEmailRequestApi;
import com.engopy.mailman.service.EmailService;
import com.engopy.mailman.service.mapper.BasicEmailMapper;
import com.engopy.mailman.service.mapper.TemplateEmailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
public class EmailController {
    @Autowired
    private EmailService emailService;

    @PostMapping(value = "/basic")
    public HttpStatus sendBasic(@RequestBody BasicEmailRequestApi basicEmailRequestApi){
        emailService.sendEmail(BasicEmailMapper.fromApiToModel(basicEmailRequestApi));
        return HttpStatus.ACCEPTED;
    }

    @PostMapping(value = "/template")
    public HttpStatus sendTemplate(@RequestBody TemplateEmailRequestApi templateEmailRequestApi){
        emailService.sendEmail(TemplateEmailMapper.fromApiToModel(templateEmailRequestApi));
        return HttpStatus.ACCEPTED;
    }
}
