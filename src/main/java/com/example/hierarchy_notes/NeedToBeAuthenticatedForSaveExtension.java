//package com.example.hierarchy_notes;
//
//import com.github.vincemann.springrapid.acl.service.extensions.security.AbstractSecurityExtension;
//import com.github.vincemann.springrapid.core.model.IdentifiableEntity;
//import com.github.vincemann.springrapid.core.proxy.CrudServiceExtension;
//import com.github.vincemann.springrapid.core.security.RapidSecurityContext;
//import com.github.vincemann.springrapid.core.service.CrudService;
//import com.github.vincemann.springrapid.core.service.exception.BadEntityException;
//import com.github.vincemann.springrapid.core.slicing.ServiceComponent;
//import org.springframework.security.access.AccessDeniedException;
//
//@ServiceComponent
//public class NeedToBeAuthenticatedForSaveExtension extends AbstractSecurityExtension<CrudService>
//        implements CrudServiceExtension<CrudService> {
//
//    @Override
//    public IdentifiableEntity save(IdentifiableEntity entity) throws BadEntityException {
//        boolean anon = !RapidSecurityContext.isAuthenticated();
//        if (anon){
//            throw new AccessDeniedException("User needs to be logged in to create File");
//        }
//        return getNext().save(entity);
//    }
//
//
//}
