package com.look.monkey.dataInit;

import com.look.monkey.entity.User;
import com.look.monkey.entity.report.OriginalReport.OriginalReport;
import com.look.monkey.entity.report.OriginalReport.OriginalReportProGrammeData;
import com.look.monkey.entity.report.OriginalReport.OriginalReportSessionData;
import com.look.monkey.repository.UserRepository;
import com.look.monkey.repository.cinema.CinemaRepository;
import com.look.monkey.repository.report.OriginalReportProGrammeDataRepository;
import com.look.monkey.repository.report.OriginalReportRepository;
import com.look.monkey.repository.report.OriginalReportSessionDataRepository;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.look.monkey.entity.Customer;
import com.look.monkey.repository.CustomerRepository;
/**
 * 项目启动后 初始化数据
 */
@Component
public class InitData implements CommandLineRunner{
	
	@Autowired
	private CustomerRepository re;

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	 @Autowired
	    private CinemaRepository cinemaRepository;
	 
	 
	 @Autowired
	    private OriginalReportRepository originalReportRepository;
	    @Autowired
	    private OriginalReportSessionDataRepository sessionDataRepository;
	    
	    
	    @Autowired
	    private OriginalReportProGrammeDataRepository proGrammeDataRepository;
	 
	@Override
	@Transactional
	public void run(String... paramArrayOfString) throws Exception {
		/*re.save(new Customer("佳佳","泰迪"));
		re.save(new Customer("广磊","笨熊"));
		User user = new User();
		user.setUsername("admin");
		user.setPassword(this.passwordEncoder.encode("123456"));
		userRepository.save(user);*/
//		initOrgReportData();
	}

	
    private void initOrgReportData() {
        String[] programmeStream = {"2017050401"};
        final LocalDate localDate = LocalDate.parse("2017-07-01");
        for ( int i =0;i<localDate.lengthOfMonth();i++){
            final LocalDate tempLocalDate = localDate.plusDays(i);
            cinemaRepository.findAll().stream().forEach(cinema -> {
                final OriginalReport originalReport = new OriginalReport();
                originalReport.setCinemaStatus(1);
                originalReport.setCinemaCode(cinema.getCode());
                originalReport.setBusinessDate(java.sql.Date.valueOf(tempLocalDate));
                final int sessionCount = RandomUtils.nextInt(1,10);
                originalReport.setSessionCount(sessionCount);
                LocalDateTime localDateTime = tempLocalDate.atTime(RandomUtils.nextInt(0,24),RandomUtils.nextInt(0,60),RandomUtils.nextInt(0,60));
                originalReport.setReportTime(Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant()));
                this.originalReportRepository.save(originalReport);
                for (int j = 0; j <sessionCount ; j++) {
                    OriginalReportSessionData sessionData = new OriginalReportSessionData();
                    sessionData.setOriginalReport(originalReport);
                    sessionData.setScreenCode(RandomStringUtils.randomNumeric(10));
                    sessionData.setSessionCode(RandomStringUtils.randomNumeric(10));
                    sessionData.setAudienceCount(RandomUtils.nextInt(1,30));
                    LocalDateTime startTime = tempLocalDate.atStartOfDay().withHour(j).withMinute(RandomUtils.nextInt(1,60)).withSecond(RandomUtils.nextInt(1,60));
                    sessionData.setSessionStartDateTime(Date.from(startTime.atZone(ZoneId.systemDefault()).toInstant()));
                    LocalDateTime endTime = tempLocalDate.atStartOfDay().withHour(j+RandomUtils.nextInt(1,2)).withMinute(RandomUtils.nextInt(1,60)).withSecond(RandomUtils.nextInt(1,60));
                    sessionData.setSessionEndDateTime(Date.from(endTime.atZone(ZoneId.systemDefault()).toInstant()));
                    sessionData.setNetAgentFee(RandomUtils.nextLong(0,1000000));
                    sessionData.setServiceFee(RandomUtils.nextLong(0,10000));
                    sessionData.setAdSales(RandomUtils.nextLong(0,1000));
                    sessionData.setRelationSales(RandomUtils.nextLong(0,10000));
                    sessionData.setOtherSales(RandomUtils.nextLong(0,10000));
                    sessionData.setEntryCount(2);
                    Arrays.stream(programmeStream).forEach(s -> {
                        OriginalReportProGrammeData proGrammeData = new OriginalReportProGrammeData();
                        proGrammeData.setProgrammeCode(s);
                        proGrammeData.setHas_seen(1);
                        proGrammeData.setProgrammeSales(RandomUtils.nextLong(0,200));
                        proGrammeData.setProgrammeOtherSales(RandomUtils.nextLong(0,2000));
                        proGrammeData.setOriginalReportSessionData(sessionData);
                        proGrammeDataRepository.save(proGrammeData);
                    });
                    this.sessionDataRepository.save(sessionData);
                }
            });
        }

    }
	
}
