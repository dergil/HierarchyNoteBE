//package com.example.hierarchy_notes;
//
//import com.github.vincemann.springrapid.acl.proxy.Acl;
//import com.github.vincemann.springrapid.acl.proxy.Secured;
//import com.github.vincemann.springrapid.acl.service.extensions.acl.AuthenticatedHasFullPermissionAboutSavedAclExtension;
//import com.github.vincemann.springrapid.core.proxy.ServiceExtensionProxyBuilder;
//import com.github.vincemann.springrapid.core.slicing.ServiceConfig;
//import org.springframework.context.annotation.Bean;
//
//// Alternative proxy configuration
//@ServiceConfig
//public class FileServiceConfig {
//
//    @Bean
//    public FileService fileService(){
//        return new JpaFileService();
//    }
//
//    @Acl
//    @Bean
//    public FileService aclFileService(FileService fileService, AuthenticatedHasFullPermissionAboutSavedAclExtension authenticatedHasFullPermissionAboutSavedAclExtension){
//        return new ServiceExtensionProxyBuilder<>(fileService)
//                .addExtensions(authenticatedHasFullPermissionAboutSavedAclExtension)
//                .build();
//    }
//
//    @Secured
//    @Bean
//    public FileService securedFileService(@Acl FileService aclFileService){
//        return new ServiceExtensionProxyBuilder<>(aclFileService)
//                .toggleDefaultExtensions(Boolean.TRUE)
//                .build();
//    }
//
//
//}
