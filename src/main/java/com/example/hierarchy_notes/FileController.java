package com.example.hierarchy_notes;

import com.example.hierarchy_notes.dto.CreateFileDto;
import com.example.hierarchy_notes.dto.ReadFileDto;
import com.example.hierarchy_notes.dto.UpdateFileDto;
import com.github.vincemann.springrapid.core.controller.CrudController;
import com.github.vincemann.springrapid.core.controller.dto.mapper.context.CrudDtoMappingContextBuilder;
import com.github.vincemann.springrapid.core.controller.dto.mapper.context.DtoMappingContext;
import org.springframework.stereotype.Controller;

@Controller
public class FileController extends CrudController<File, String, FileService> {

    @Override
    protected DtoMappingContext provideDtoMappingContext(CrudDtoMappingContextBuilder builder) {
        return builder
                .forEndpoint(getCreateUrl(), CreateFileDto.class)
                .forUpdate(UpdateFileDto.class)


                //response dto config
                //not authenticated
                .withAllPrincipals()
                .forResponse(ReadFileDto.class)
                .build();
    }

}
