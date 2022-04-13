package com.engopy.mailman.service.mapper;

import com.engopy.mailman.api.BasicEmailRequestApi;
import com.engopy.mailman.service.model.BasicEmailRequest;
import org.modelmapper.ModelMapper;

public class BasicEmailMapper {

    public static BasicEmailRequest fromApiToModel(BasicEmailRequestApi api){
        if(api == null) return null;
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(api, BasicEmailRequest.class);
    }

    public static BasicEmailRequestApi fromModelToApi(BasicEmailRequest model){
        if(model == null) return null;
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(model, BasicEmailRequestApi.class);
    }

}
