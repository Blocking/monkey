package com.look.monkey.repository.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.look.monkey.entity.User;


public interface UserRepository extends CrudRepository<User, Long>{

    User findFirstByUsername(String username);

    Optional<User> findOneByUsername(String username);

    @Override
    List<User> findAll();

}