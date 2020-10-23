package com.look.monkey.repository.redis;

import com.look.monkey.entity.redis.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student,String> {
}
