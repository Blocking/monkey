package com.look.monkey.entity.vodtBase;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Index;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.look.monkey.entity.base.BaseEntity;
import com.look.monkey.enums.CityType;

import lombok.Getter;
import lombok.Setter;

/**
 * 地市表
 */
@Getter
@Setter
@Entity
@Table(indexes = {@Index(columnList = "code", name = "IDX_CITY_CODE") })
public class City extends BaseEntity {


    /**
     * 省
     */
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private Province province;

    /**
     * 市编码
     */
    @NotBlank
    @Length(max = 6, min = 6)
    @Column(unique = true, updatable = false, nullable = false, length = 6)
    private String code;
    
    /**
     * 市编码
     */
    @NotBlank
    @Length(max = 6, min = 6)
    @Column(unique = true, updatable = false, nullable = false, length = 6)
    private String newCode;

    /**
     * 市名称
     */
    @NotBlank
    @Length(max = 50)
    @Column(nullable = false, length = 50)
    private String name;

    /**
     * 城市类型
     */
    @Enumerated(EnumType.STRING)
    private CityType type;

    /**
     * 可用状态
     */
    private boolean actived = true;

    /**
     * 排序
     */
    private int orderNum = 0;

}
