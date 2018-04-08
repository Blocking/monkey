package com.look.monkey.entity.chain;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.look.monkey.entity.base.BaseEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * @create 2017-05-22 16:55
 */
@Getter
@Setter
@Entity
public class CinemaChainBaseInfo extends BaseEntity {
    /**
     * 业务联系人
     */
    @Length(max = 64)
    @Column(length = 64)
    private String businessPerson;
    /**
     * 电话
     */
    @NotBlank
    @Length(max = 64)
    @Column(nullable = false, length = 64)
    private String telephone;
    /**
     * 法人
     */
    @NotBlank
    @Length(max = 50)
    @Column(nullable = false, length = 50)
    private String legalPerson;
    /**
     * 地址
     */
    @Length(max = 512)
    @Column(length = 512)
    private String address;
    /**
     *电子邮箱
     */
    @NotBlank
    @Length(max = 64)
    @Column(nullable = false, length = 64)
    private String email;
}
