package com.look.monkey.entity.vodtBase;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;

import com.look.monkey.entity.base.BaseEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * 大区<br/>
 * 例如：东北区、华北区<br/>
 * 用于统计查询
 */
@Getter
@Setter
@Entity
@Table(indexes = {@Index(columnList = "code", name = "IDX_REGION_CODE") })
public class Region extends BaseEntity {


    /**
     * 大区编码
     */
    @Length(max = 6, min = 6)
    @Column(unique = true, updatable = false, nullable = false, length = 6)
    private String code;

    /**
     * 大区名称
     */
    @Length(max = 50)
    @Column(length = 50)
    private String name;

    /**
     * 可用状态
     */
    private boolean actived = true;

    /**
     * 排序
     */
    private int orderNum = 0;

}
