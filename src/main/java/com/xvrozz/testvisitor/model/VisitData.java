package com.xvrozz.testvisitor.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="visitdata")
public class VisitData {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
	
    @Column(name ="userid")
    private Long userId;
    
    @Column(name ="visitedpage")
    private String visitedPage;
    
    @Column(name ="visitdatetime")
    private LocalDateTime visitDateTime;

    public VisitData(String visitedPage, Long userId, LocalDateTime visitDateTime) {
    	this.visitedPage = visitedPage;
    	this.userId = userId;
    	this.visitDateTime = visitDateTime;
    }
}
