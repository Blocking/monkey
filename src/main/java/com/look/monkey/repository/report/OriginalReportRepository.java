package com.look.monkey.repository.report;

import java.sql.Date;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.data.repository.Repository;

import com.look.monkey.entity.report.OriginalReport.OriginalReport;

public interface OriginalReportRepository extends Repository<OriginalReport, Long>{
	
	OriginalReport findOne(Long id);
	
	OriginalReport save(OriginalReport originalReport);

	Stream<OriginalReport> findAll();

    Long countByBusinessDateAndCinemaCodeIn(Date date, List<String> cinemaCodes);

	OriginalReport findByBusinessDateAndCinemaCode(java.util.Date date, String cinemaCode);

	void delete(OriginalReport originalReport);
}
