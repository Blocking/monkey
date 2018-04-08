package com.look.monkey.repository.report;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.look.monkey.entity.report.OriginalReport.OriginalReport;
import com.look.monkey.entity.report.OriginalReport.OriginalReportSessionData;

public interface OriginalReportSessionDataRepository extends Repository<OriginalReportSessionData, Long>{
	OriginalReportSessionData findOne(Long id);
	
	OriginalReportSessionData save(OriginalReportSessionData originalReportSessionData);

	List<OriginalReportSessionData> findByOriginalReportCinemaCodeAndScreenCodeAndSessionCode(String cinemaCode,String screenCode,String sessionCode);

    List<OriginalReportSessionData> findAllByOriginalReport(OriginalReport originalReport);

    void delete(Long id);

    List<OriginalReportSessionData> findByOriginalReportIsNull();

}
