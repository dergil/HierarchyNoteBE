package com.example.hierarchy_notes.auth;


import com.github.vincemann.springrapid.auth.service.UserService;
import com.github.vincemann.springrapid.core.slicing.ServiceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

@ServiceConfig
public class UserServiceConfig {

    @Bean
    @Primary
    public UserService userService(){
        return new MyUserService();
    }


}
