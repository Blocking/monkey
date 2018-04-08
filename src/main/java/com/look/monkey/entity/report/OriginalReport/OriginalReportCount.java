package com.look.monkey.entity.report.OriginalReport;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import com.look.monkey.entity.base.BaseEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by PH on 2017/8/3.
 *  影院原始上报次数统计
 */
@Getter
@Setter
@Entity
public class OriginalReportCount extends BaseEntity {
    /**
     * 影院编码
     */
    /**
     * 影院编码
     */
    @NotNull
    @Column(nullable = false,length = 11)
    private String cinemaCode;
    /**
     * 院线编码
     */
    @NotNull
    @Column(nullable = false,length = 8)
    private String chainCode;
    /**
     * 上报日期
     */
    @NotNull
    private String reportDate;
    /**
     * 上报次数
     */
    private int reportCount;
}
