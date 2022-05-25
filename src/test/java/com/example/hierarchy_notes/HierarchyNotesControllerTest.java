package com.example.hierarchy_notes;

import com.github.vincemann.acltest.controller.AclIntegrationCrudControllerTest;
import com.github.vincemann.springrapid.core.controller.GenericCrudController;
import com.github.vincemann.springrapid.core.service.CrudService;
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;

import java.io.Serializable;

public abstract class HierarchyNotesControllerTest <
        C extends GenericCrudController<?, Id, S, ?, ?>,
        Id extends Serializable,
        S extends CrudService<?, Id>
        >
        extends AclIntegrationCrudControllerTest<C, S> {

    @Override
    protected DefaultMockMvcBuilder createMvcBuilder() {
        DefaultMockMvcBuilder mvcBuilder = super.createMvcBuilder();
        mvcBuilder.apply(SecurityMockMvcConfigurers.springSecurity());
        return mvcBuilder;
    }
}
