package com.example.hierarchy_notes;

import com.github.vincemann.springrapid.core.service.CrudService;
import com.github.vincemann.springrapid.core.slicing.ServiceComponent;


@ServiceComponent
public interface FileService extends CrudService<File,Long> {
}
