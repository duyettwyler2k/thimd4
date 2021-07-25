package com.codegym.module4thi.service.user;

import com.codegym.module4thi.model.User;
import com.codegym.module4thi.service.IGeneralService;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUserService extends IGeneralService<User>, UserDetailsService {
    User findByUsername(String username);
}
