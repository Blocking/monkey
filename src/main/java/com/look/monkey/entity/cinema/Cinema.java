package com.look.monkey.entity.cinema;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.look.monkey.entity.base.BaseEntity;
import com.look.monkey.entity.chain.CinemaChain;
import com.look.monkey.entity.vodtBase.City;
import com.look.monkey.entity.vodtBase.County;
import com.look.monkey.entity.vodtBase.Province;
import com.look.monkey.entity.vodtBase.Region;
import com.look.monkey.enums.BusinessStatus;

import lombok.Getter;
import lombok.Setter;

/**
 * 影院
 */
@Setter
@Getter
@Entity
public class Cinema extends BaseEntity{

	
	/**
	 * 影院编码
	 */
	@NotBlank
	@Length(max = 10)
	@Column(nullable = false,length = 10, unique = true)
	private String code;
	
	/**
     * 影院名称
     */
    @NotBlank
    @Length(max = 150)
    @Column(nullable = false, length = 150)
	private String shortName;
    
    /**
     * 工商局注册名称
     */
    @Length(max = 150)
    @Column(length = 150)
    private String gsjRegisteredName;
    
    /**
     * 营业执照证件号码
     */
    @Length(max = 150)
    @Column(length = 150)
    private String licenseNo;
    
    /**
     * 售票系统名称
     */
    @Length(max = 150)
    @Column(length = 150)
    private String ticketSystemName;
    
    /**
     * 使用软件版本号
     */
    @Length(max = 150)
    @Column(length = 150)
    private String softwareVersion;
    
    /**
     * 注册时间
     */
    @Temporal(TemporalType.DATE)
    private Date time;
    
    /**
     * 营业状态  wait未审核, test测试, open营业, close停业, cancel注销
     */
    @NotNull
    @Enumerated(EnumType.STRING)
    private BusinessStatus businessStatus = BusinessStatus.test;
    
    /**
     * 停业开始时间
     */
    @Temporal(TemporalType.DATE)
    private Date closeStartTime;
    
    /**
     * 停业结束时间
     */
    @Temporal(TemporalType.DATE)
    private Date closeEndTime;
    
    /**
     * 基础信息
     */
    @NotNull
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
    private CinemaBasicInfo basicInfo = new CinemaBasicInfo();
    
    /**
     * 所处院线
     */
    @ManyToOne(fetch = FetchType.LAZY)
    private CinemaChain cinemaChain;
    
    /**
     * 区（大区）
     */
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private Region region;

    /**
     * 省
     */
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private Province province;

    /**
     * 市
     */
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private City city;

    /**
     * 市区或县区
     */
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private County county;
    
    
    /**
     * 点播影院影厅
     */
    @NotNull
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "CINEMA_ID")
    private List<CinemaScreen> screens = new ArrayList<CinemaScreen>();


    /**
     *许可证ID
     */
    @Length(max = 64)
    @Column(length = 64)
    private String licenceId;
    /**
     *营业执照ID
     */
    @Length(max = 64)
    @Column(length = 64)
    private String businessLicenceId;
    /**
     *登记表ID
     */
    @Length(max = 64)
    @Column(length = 64)
    private String registrationFormId;
    
    /**
     * 上传文件nos 以逗号分隔
     */
    private String fileNos;
}
