package com.look.monkey.entity.cinema;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.look.monkey.entity.base.BaseEntity;
import com.look.monkey.enums.CinemaEnterpriseType;
import com.look.monkey.enums.CinemaPlaceType;

import lombok.Getter;
import lombok.Setter;

/**
 * 影院基础信息
 */
@Getter
@Setter
@Entity
public class CinemaBasicInfo extends BaseEntity {


    /**
     * 点播影院邮编
     */
    @NotBlank
    @Length(max = 6)
    @Column(nullable = false, length = 6)
    private String zipCode;
    
    /**
     * 点播影院序号
     */
    @NotBlank
    @Length(max = 6)
    @Column(nullable = false, length = 6)
    private String orderNum;

    /**
     * 点播影院地址
     */
    @NotBlank
    @Length(max = 512)
    @Column(nullable = false, length = 512)
    private String address;
    
    /**
     * 传真号码
     */
    @NotBlank
    @Length(max = 64)
    @Column(nullable = false, length = 64)
    private String faxNumber;

    /**
     * 点播影院经理姓名
     */
    @NotBlank
    @Length(max = 50)
    @Column(nullable = false, length = 50)
    private String manager;

    /**
     * 点播影院经理电话
     */
    @NotBlank
    @Length(max = 64)
    @Column(nullable = false, length = 64)
    private String managerTel;

    /**
     * 法人代表
     */
    @Length(max = 50)
    @Column(length = 50)
    private String legalPerson;

    /**
     * 法人代表电话
     */
    @Length(max = 64)
    @Column(length = 64)
    private String legalPersonTel;

    /**
     * 企业性质 国营 合资 外资 民营
     */
    @Enumerated(EnumType.STRING)
    private CinemaEnterpriseType enterpriseType;

    /**
     * 场地属性 租赁 租借
     */
    @Enumerated(EnumType.STRING)
    private CinemaPlaceType placeType;
    
    private String placeTypeDetail;

    /**
     * 员工总数
     */
    private Integer stuffs;

    /**
     * 放映人员数量
     */
    private Integer players;

    /**
     * 固定资产（万元）
     */
    private BigDecimal fixedAssets;

    /**
     * 建设投资金额（万元）
     */
    private BigDecimal invest;

    /**
     * 备注
     */
    @Length(max = 512)
    @Column(length = 512)
    private String remarks;

    
}
