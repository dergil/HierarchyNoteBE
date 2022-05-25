package com.example.hierarchy_notes;

import com.github.vincemann.springrapid.acl.service.RapidPermissionService;
import com.github.vincemann.springrapid.core.security.RapidSecurityContext;
import com.github.vincemann.springrapid.core.security.Roles;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.acls.model.MutableAclService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CustomRapidPermissionService extends RapidPermissionService {
    public CustomRapidPermissionService(MutableAclService aclService) {
        super(aclService);
    }

//    anon user can create files for now
    protected String findAuthenticatedName(){
//        if (RapidSecurityContext.hasRole(Roles.ANON)){
//            throw new AccessDeniedException("Non anon Authentication required");
//        }
        String name = RapidSecurityContext.getName();
        //Nicht auslagern. MutableAclService macht das intern auch so -> use @MockUser(username="testUser") in tests
//        if(name==null){
//            throw new AccessDeniedException("Authentication required");
//        }
        return name;
    }
}
