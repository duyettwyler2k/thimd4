package com.codegym.module4thi.service.user;

import com.codegym.module4thi.model.User;
import com.codegym.module4thi.model.UserPrincipal;
import com.codegym.module4thi.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserService implements IUserService{
    @Autowired
    private IUserRepository userRepository;
    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void remove(Long id) {
         userRepository.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user= userRepository.findAllByUsername(username);
        return UserPrincipal.build(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findAllByUsername(username);
    }
}
