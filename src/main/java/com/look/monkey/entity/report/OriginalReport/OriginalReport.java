package com.look.monkey.entity.report.OriginalReport;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.look.monkey.entity.base.BaseEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by E0441 on 2017/6/19.
 * 院线原始场次上报数据
 */
@Getter
@Setter
@Entity
public class OriginalReport extends BaseEntity {
    /**
     * 影院编码
     */
    @NotNull
    @Column(nullable = false,length = 11)
    private String cinemaCode;
    /**
     * 影院营业状态
     * 1 测试
     * 2 正常
     */
    @Column
    private Integer cinemaStatus;
    /**
     *营业日期
     */
    @Temporal(TemporalType.DATE)
    private Date businessDate;

    /**
     * 场次数量
     */
    private Integer sessionCount;

    /**
     * 上报时间
     */
    @Temporal(TemporalType.TIMESTAMP)
    private Date reportTime;

    @OneToMany(mappedBy = "originalReport",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<OriginalReportSessionData> originalReportSessionDatas = new ArrayList<>();

}
