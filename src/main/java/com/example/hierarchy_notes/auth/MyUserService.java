package com.example.hierarchy_notes.auth;

import com.github.vincemann.springrapid.auth.AuthProperties;
import com.github.vincemann.springrapid.auth.service.AbstractUserService;
import org.springframework.transaction.annotation.Transactional;

//@ServiceComponent
//@Primary
@Transactional
public class MyUserService extends AbstractUserService<User, Long, UserRepository> {

	@Override
    public User newUser() {
        return new User();
    }

	@Override
	public Long toId(String id) {
		return Long.valueOf(id);
	}

	@Override
	public Class<?> getTargetClass() {
		return MyUserService.class;
	}

//	@Override
//	public User newAdmin(AuthProperties.Admin admin) {
//		User createdAdmin = super.newAdmin(admin);
//		createdAdmin.setName(admin.getEmail()+"name");
//		return createdAdmin;
//	}
}