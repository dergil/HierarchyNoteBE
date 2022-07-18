package com.example.hierarchy_notes;

import com.example.hierarchy_notes.dto.CreateFileDto;
import com.example.hierarchy_notes.dto.ReadFileDto;
import com.example.hierarchy_notes.dto.UpdateFileDto;
import com.github.vincemann.springrapid.core.controller.CrudController;
import com.github.vincemann.springrapid.core.controller.dto.mapper.context.CrudDtoMappingContextBuilder;
import com.github.vincemann.springrapid.core.controller.dto.mapper.context.DtoMappingContext;
import com.github.vincemann.springrapid.core.security.RapidSecurityContext;
import com.github.vincemann.springrapid.core.service.exception.BadEntityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class FileController extends CrudController<File, Long, FileService> {

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

//    @Autowired
//    private FileService fileService;

//    @Override
//    protected File serviceCreate(File entity) throws BadEntityException {
//        if (RapidSecurityContext.isAuthenticated()){
//            return getService().save(entity);
//        }else {
//            // anon can create files
//            return fileService.save(entity);
//        }
//    }

}
