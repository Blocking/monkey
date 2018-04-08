package com.look.monkey.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.look.monkey.entity.QUser;
import com.look.monkey.entity.User;
import com.look.monkey.repository.UserRepository;
import com.look.monkey.repository.Abstract.AbstractRepository;
import com.look.monkey.service.UsersService;

@Service
@Transactional
public class UsersServiceImpl extends AbstractRepository<User> implements UsersService {

    @Autowired
    private UserRepository userRepository;
    
    final QUser qUser = QUser.user;

    @Autowired
    public PasswordEncoder passwordEncoder;


    @Override
    public User getUserByUserName(final String username) {
        return this.selectFrom(qUser).where(qUser.username.contains(username)).fetchOne();
    }

    @Override
    public List<User> getAll() {
        return this.userRepository.findAll();
    }

    @Override
    public User save(final User user) {
        user.setPassword(this.passwordEncoder.encode(user.getPassword()));
        return this.userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        return this.userRepository.findOneByUsername(username).orElseThrow(
                () -> new UsernameNotFoundException(String.format("用户对应的用户名：%s 不存在！", username)));
    }

}
