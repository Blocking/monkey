package com.look.monkey.entity.cinema;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.look.monkey.entity.base.BaseEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * 影厅信息<br/>
 * 与影院 信息是多对一的关系
 */
@Getter
@Setter
@Entity
public class CinemaScreen extends BaseEntity {


    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER,cascade= CascadeType.ALL)
    @JoinColumn(name="CINEMA_ID")
    private Cinema cinema;
    /**
     * 影厅编码
     */
    @NotBlank
    @Length(max = 16)
    @Column(nullable = false, length = 16)
    private String code;

    /**
     * 影厅名称
     */
    @NotBlank
    @Length(max = 64)
    @Column(nullable = false, length = 64)
    private String name;

    /**
     * 座位数量（个）
     */
    @NotNull
    private Integer seats;
    
    /**
     * 放映设备名称
     */
    private String projectionName;
    
    /**
     * 放映设备型号
     */
    private String projectionType;
    
    /**
     * 荧幕/屏幕宽度（米）
     */
    private Integer screenWidth;

    /**
     * 厅面积（㎡）
     */
    private Integer area;

    /**
     * 可用状态
     */
    private boolean actived = true;

}
