package com.xvrozz.testvisitor.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import com.xvrozz.testvisitor.model.VisitData;


@Repository
public interface VisitDataRepository extends CrudRepository<VisitData, Long>  {
	
	@Async
	public VisitData save(VisitData visitData);
	
	public int countByVisitedPageAndVisitDateTimeGreaterThan(String visitedPage, LocalDateTime localDateTime);
	
	@Query("Select count(distinct userId) from VisitData vd where vd.visitedPage = ?1 and vd.visitDateTime > ?2")
	public Integer pageDailyUniqueVisitCount(String visitedPage, LocalDateTime localDateTime);
	
	@Query("Select count(distinct id) from VisitData vd where vd.visitDateTime > ?1 and vd.visitDateTime < ?2")
	public Integer countTotalVisitCount(LocalDateTime from, LocalDateTime to);
	
	@Query("Select count(distinct userId) from VisitData vd where vd.visitDateTime >= ?1 and vd.visitDateTime <= ?2")
	public Integer countUniqueUserCount(LocalDateTime from, LocalDateTime to);
	
	@Query(value="select count(*) from (\r\n" + 
		"select userid from (SELECT userid, visitedpage  FROM visitdata  group by userid, visitedpage  )  "
		+ "GROUP by userid having count(*) >= 10  )",
		nativeQuery = true)
	public Integer countConstUser(LocalDateTime from, LocalDateTime to);
	
}