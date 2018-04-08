package com.look.monkey.entity.report.OriginalReport;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.look.monkey.entity.base.BaseEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by E0441 on 2017/6/19.
 * 原始上报场次数据
 */
@Setter
@Getter
@Entity
public class OriginalReportSessionData extends BaseEntity{

    /**
     * 原始上报影院信息
     */
    @ManyToOne(fetch = FetchType.LAZY)
    private OriginalReport originalReport;
    /**
     * 原始上报 视听节目信息
     */
    @OneToMany(mappedBy = "originalReportSessionData",fetch = FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval=true)
    private List<OriginalReportProGrammeData> originalReportProGrammeDatas = new ArrayList<>();
    /**
     * 影厅编码
     */
    @NotNull
    @Column(nullable = false,length = 17)
    private String screenCode;
    /**
     * 场次编码
     */
    @NotNull
    @Column(nullable = false,length = 17)
    private String sessionCode;
    /**
     * 观影人数
     */
    @NotNull
    private Integer audienceCount;
    /**
     * 场次开始时间
     */
    @Temporal(TemporalType.TIMESTAMP)
    private Date sessionStartDateTime;
    /**
     * 场次结束时间
     */
    @Temporal(TemporalType.TIMESTAMP)
    private Date sessionEndDateTime;
    /**
     * 网络代售标识
     * 0:本地销售
     * 1:网络销售
     */
    @Column
    private Integer netAgentSale;
    /**
     * 网络代售编码
     */
   /* @NotNull
    @Column(nullable = false, length = 11)*/ //有的影院没云上报，作为空处理
    @Column(length = 11)
    private String netAgentCode;
    /**
     * 服务费。（网络代售服务费）
     */
    @Column
    private Long netAgentFee;

    /**
     * 包场费。（房间费用）
     */
    @Column
    private Long serviceFee;

    /**
     * 广告收入。（广告费用）
     */
    @Column
    private Long adSales;

    /**
     * 关联收入。（酒水、餐饮、零售商品等）
     */
    @Column
    private Long relationSales;

    /**
     * 其它收入（综合其它收入）。
     */
    @Column
    private Long otherSales;

    /**
     * 记录条数。
     */
    @Column
    private Integer entryCount;

    /**
     * 上报时间
     */
    @Temporal(TemporalType.TIMESTAMP)
    private Date reportTime;
}
