package com.look.monkey.repository.report;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.look.monkey.entity.report.OriginalReport.OriginalReportProGrammeData;

public interface OriginalReportProGrammeDataRepository extends Repository<OriginalReportProGrammeData, Long>{

    List<OriginalReportProGrammeData> findByOriginalReportSessionDataId(Long id);
    OriginalReportProGrammeData save(OriginalReportProGrammeData model);
    void delete(OriginalReportProGrammeData originalReportProGrammeData);
	void delete(Long id);
}
