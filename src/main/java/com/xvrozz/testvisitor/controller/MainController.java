package com.xvrozz.testvisitor.controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xvrozz.testvisitor.model.VisitData;
import com.xvrozz.testvisitor.repository.VisitDataRepository;

@RestController
@RequestMapping("/")
public class MainController {
	
    VisitDataRepository visitDataRepository;
	
    public static final int ONE = 1;


    @Autowired
    public void MainController(VisitDataRepository visitDataRepository) {
        this.visitDataRepository = visitDataRepository;
    }

    @RequestMapping(value = "page-visit", method = RequestMethod.POST)
    public Map<String, Integer> pageVisit(Long userId, String visitedPage) {
    	VisitData a =  new VisitData(visitedPage, userId, LocalDateTime.now());
    	visitDataRepository.save(a);
    	Map<String, Integer> answer = new HashMap<String, Integer>();
    	answer.put("pageDailyVisitCount", visitDataRepository
			.countByVisitedPageAndVisitDateTimeGreaterThan(visitedPage, LocalDateTime.now().minusDays(ONE)));
    	answer.put("pageDailyUniqueVisitCount", visitDataRepository
			.pageDailyUniqueVisitCount(visitedPage, LocalDateTime.now().minusDays(ONE)));
    	return answer;
    }
    
    @RequestMapping(value = "site-statistic", method = RequestMethod.GET)
    public Map<String, Integer> pageVisit(@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm") LocalDateTime from, 
    		@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm") LocalDateTime to) {
    	Map<String, Integer> answer = new HashMap<String, Integer>();
    	answer.put("totalVisitCount", visitDataRepository.countTotalVisitCount(from, to));
    	answer.put("uniqueVisitCount", visitDataRepository.countUniqueUserCount(from, to));
    	answer.put("constUserCount", visitDataRepository.countConstUser(from, to));
    	visitDataRepository.countConstUser(from, to);
    	return answer;
    }
    
}
 