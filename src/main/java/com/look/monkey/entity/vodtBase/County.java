package com.look.monkey.entity.vodtBase;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.look.monkey.entity.base.BaseEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * 区或县区<br/>
 * 例如：沙河口、中山
 *
 * @author
 */
@Getter
@Setter
@Entity
@Table(indexes = {@Index(columnList = "code", name = "IDX_COUNTY_CODE") })
public class County extends BaseEntity {

    /**
     * 市
     */
    @NotNull
    @ManyToOne
    private City city;

    /**
     * 区（县区）编码
     */
    @NotBlank
    @Length(max = 6, min = 6)
    @Column(unique = true, updatable = false, nullable = false, length = 6)
    private String code;

    /**
     * 区（县区）名称
     */
    @NotBlank
    @Length(max = 50)
    @Column(nullable = false, length = 50)
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
