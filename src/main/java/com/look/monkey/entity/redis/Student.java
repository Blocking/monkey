package com.look.monkey.entity.redis;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

/**
 * @author zhangxiaoyu
 */
@Data
@RedisHash
@AllArgsConstructor
@NoArgsConstructor
public class Student  implements Serializable {

    public enum Gender {
        MALE, FEMALE
    }

    private String id;
    private String name;
    private Gender gender;
    private int grade;

}
