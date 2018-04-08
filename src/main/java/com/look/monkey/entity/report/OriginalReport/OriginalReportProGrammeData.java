package com.look.monkey.entity.report.OriginalReport;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.look.monkey.entity.base.BaseEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by E0441 on 2017/6/19.
 */
@Setter
@Getter
@Entity
public class OriginalReportProGrammeData extends BaseEntity{

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "originalReportSessionDataId")
    private OriginalReportSessionData originalReportSessionData;

    /**
     * 视听节目编码。
     */
    @NotNull
    @Column(nullable = false,length = 15)
    private  String programmeCode;
    /**
     *  是否有效观看视听节目：
     • 1，有效观影。（发生版权限制内交易的视听节目观看活动均为有效观影）
     • 2，无有效观影(观众在一个场次内，预览视听节目、未完整观看视听节目，等各类不发生版权交易限制的观影活动均为非有效观影)

     */
    @Column
    private Integer has_seen;
    /**
     * 视听节目费用。
     */
    @Column
    private Long programmeSales;
    /**
     * 听节目其它收入
     */
    @Column
    private Long programmeOtherSales;
}
