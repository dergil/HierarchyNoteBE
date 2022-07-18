package com.example.hierarchy_notes;

import com.github.vincemann.springrapid.core.controller.GenericCrudController;
import com.github.vincemann.springrapid.core.service.CrudService;
import com.github.vincemann.springrapid.coretest.controller.integration.IntegrationCrudControllerTest;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;

import java.io.Serializable;

public abstract class HierarchyNotesControllerTest <
        C extends GenericCrudController<?, Id, S, ?, ?>,
        Id extends Serializable,
        S extends CrudService<?, Id>
        >
        extends IntegrationCrudControllerTest<C, S> {

}
