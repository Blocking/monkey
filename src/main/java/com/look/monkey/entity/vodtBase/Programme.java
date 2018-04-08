package com.look.monkey.entity.vodtBase;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.look.monkey.entity.base.BaseEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * 视听节目基类
 *
 * @create 2017-05-22 17:10
 */
@Getter
@Setter
@Entity
public class Programme extends BaseEntity{
    /**
     * 视听节目编码
     */
    @NotBlank
    @Length(max = 14)
    @Column(nullable = false, length = 14, unique = true)
    private String code;

    /**
     * 视听节目名称
     */
    @NotBlank
    @Length(max = 128)
    @Column(nullable = false, length = 128)
    private String name;

    /**
     * 修改时间
     */
    @Temporal(TemporalType.DATE)
    private Date updateTime;

    /**
     * 出品单位
     */
    @Lob
    private String publisher;

    /**
     * 影片介绍
     */
    @Lob
    private String introduction;

}
