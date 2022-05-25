package com.example.hierarchy_notes;

import com.github.vincemann.springrapid.core.proxy.annotation.CreateProxy;
import com.github.vincemann.springrapid.core.proxy.annotation.DefineProxy;
import com.github.vincemann.springrapid.core.service.JPACrudService;
import com.github.vincemann.springrapid.core.slicing.ServiceComponent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import com.github.vincemann.springrapid.acl.proxy.*;

@ServiceComponent
@Primary
@Transactional
@DefineProxy(name = "acl", extensions = {
        "authenticatedHasFullPermissionAboutSavedAclExtension"
})
@DefineProxy(name = "secured", defaultExtensionsEnabled = true )
@CreateProxy(qualifiers = Secured.class, proxies = {"acl","secured"})
@CreateProxy(qualifiers = Acl.class, proxies = "acl")
@Slf4j
@Service
public class JpaFileService
        extends JPACrudService<File,Long,FileRepository>
        implements FileService {
    @Override
    public Class<?> getTargetClass() {
        return JpaFileService.class;
    }
}
