package com.look.monkey.entity.chain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.look.monkey.entity.base.BaseEntity;
import com.look.monkey.entity.vodtBase.Province;
import com.look.monkey.enums.BusinessStatus;
import com.look.monkey.enums.ChainTypes;
import com.look.monkey.enums.Enclosure;

import lombok.Getter;
import lombok.Setter;

/**
 * 院线基本信息
 */
@Getter
@Setter
@Entity
public class CinemaChain extends BaseEntity{

    /**
     * 院线编码
     */
    @NotBlank
    @Length(max = 8)
    @Column(nullable = false, length = 8, unique = true)
    private String code;
    /**
     * 院线名称
     */
    @NotBlank
    @Length(max = 128)
    @Column(nullable = false, length = 128, unique = true)
    private String name;
    /**
     * 院线类型
     */
    @NotNull
    @Enumerated(EnumType.STRING)
    private ChainTypes type;
    /**
     * 所属省份
     */
    @ManyToOne(fetch = FetchType.LAZY)
    private Province province;
    

    /**
     * 营业状态  wait未审核, test测试, open营业, close停业, cancel注销
     */
    @NotNull
    @Enumerated(EnumType.STRING)
    private BusinessStatus businessStatus /*= BusinessStatus.wait*/;

    /**
     * 正式营业日期（第一次开始正式营业的日期）
     */
    @Temporal(TemporalType.DATE)
    private Date formalBusinessDate;
    /**
     * 基础数据
     */
    @NotNull
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
    CinemaChainBaseInfo baseInfo = new CinemaChainBaseInfo();
    
    /**
     * 注册时间
     */
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date registTime;
    
    /**
     * 院线公司工商注册所在地
     */
//    @NotNull
    private String registerPlace;
    
    /**
     * 筹建证/许可证
     */
    @Enumerated(EnumType.STRING)
    private Enclosure enclosure;
    
    /**
     * 筹建状态
     */
    private boolean preparationState;
    
    /**
     * 筹建开始时间
     */
    @Temporal(TemporalType.DATE)
    private Date startTime;
    
    /**
     * 筹建结束时间
     */
    @Temporal(TemporalType.DATE)
    private Date endTime;
    
    /**
     * 计费系统版本
     */
    private String chargingVersion;
    
    /**
     * 计费系统名称
     */
    private String chargingName;
    
    /**
     * 检测通过时间
     */
    @Temporal(TemporalType.DATE)
    private Date checkPassDate;
    
    /**
     * 许可证号
     */
    private String licenseKey;
    
    /**
     * 许可证时间
     */
    @Temporal(TemporalType.DATE)
    private Date licenseTime;

    /**
     *许可证ID
     */
    @Length(max = 64)
    @Column(length = 64)
    private String licenceId;
    
    /**
     *筹建证ID
     */
    @Length(max = 64)
    @Column(length = 64)
    private String preparationId;
    /**
     *营业执照ID
     */
    @Length(max = 64)
    @Column(nullable = false, length = 64)
    private String businessLicenceId;
    /**
     *登记表ID
     */
    @Length(max = 64)
    @Column(nullable = false, length = 64)
    private String registrationFormId;
    /**
     *计费系统检测报告ID
     */
    @Length(max = 64)
    @Column(length = 64)
    private String chargingReportId;
    /**
     *经营范围，省，逗号分隔
     */
    @Length(max = 256)
    @Column(length = 256)
    private String businessScope;

    /**
     * 文件
     */
    private String fileNos;

    /**
     * 创建人
     */
    private String created;

    /**
     * 创建时间
     */
    private Date createdDate;

}
