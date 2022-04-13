package com.engopy.mailman.service.mapper;

import com.engopy.mailman.api.BasicEmailRequestApi;
import com.engopy.mailman.api.TemplateEmailRequestApi;
import com.engopy.mailman.service.model.BasicEmailRequest;
import com.engopy.mailman.service.model.TemplateEmailRequest;
import org.modelmapper.ModelMapper;

public class TemplateEmailMapper {

    public static TemplateEmailRequest fromApiToModel(TemplateEmailRequestApi api){
        if(api == null) return null;
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(api, TemplateEmailRequest.class);
    }

    public static TemplateEmailRequestApi fromModelToApi(TemplateEmailRequest model){
        if(model == null) return null;
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(model, TemplateEmailRequestApi.class);
    }
}
