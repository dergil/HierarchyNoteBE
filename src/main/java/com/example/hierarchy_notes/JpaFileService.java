package com.example.hierarchy_notes;

import com.github.vincemann.springrapid.core.service.JPACrudService;
import org.springframework.stereotype.Service;


@Service
public class JpaFileService
        extends JPACrudService<File,String,FileRepository>
        implements FileService {
    @Override
    public Class<?> getTargetClass() {
        return JpaFileService.class;
    }
}
