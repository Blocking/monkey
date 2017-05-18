/*
 * Copyright 2011-2014 the original author or authors. Licensed under the Apache
 * License, Version 2.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0 Unless required by applicable law
 * or agreed to in writing, software distributed under the License is
 * distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package com.look.monkey.service.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.look.monkey.entity.QUser;
import com.look.monkey.entity.User;
import com.look.monkey.repository.UserRepository;
import com.look.monkey.service.UsersService;
import com.querydsl.jpa.impl.JPAQuery;

@Repository
@Transactional
public class UsersServiceImpl implements UsersService {

    @Autowired
    private EntityManager em;
    @Autowired
    private UserRepository userRepository;

    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Override
    public User getUserByUserName(final String username) {
        final QUser qUser = QUser.user;
        final JPAQuery<User> query = new JPAQuery<>(this.em);
        return query.from(qUser).select(qUser).where(qUser.username.contains(username)).fetchOne();
    }

    @Override
    public List<User> getAll() {
        return this.userRepository.findAll();
    }

    @Override
    public User save(final User user) {
        user.setPassword(this.passwordEncoder().encode(user.getPassword()));
        return this.userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        return this.userRepository.findOneByUsername(username).orElseThrow(
                () -> new UsernameNotFoundException(String.format("用户对应的用户名：%s 不存在！", username)));
    }

}
