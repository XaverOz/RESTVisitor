package com.xvrozz.testvisitor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
class RestVisitorApplicationTests {
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@LocalServerPort
	private int port;

	@Test
	void siteStatisticTest() {
		Map<String, Integer> testMap = new HashMap<>();
		testMap.put("totalVisitCount", 0);
		testMap.put("constUserCount", 0);
		testMap.put("uniqueVisitCount", 0);
		Map<String, Integer> responseMap = restTemplate.getForObject("http://localhost:" + port + "/site-statistic", Map.class);
		assertEquals(responseMap, testMap);
	}
	
	@Test
	void pageVisitTest() {
		Map<String, String> params = new HashMap<String, String>();
		params.put("userId", "user");
		params.put("visitedPage", "/main");
		Map<String, Integer> responseMap = restTemplate.postForObject("http://localhost:" + port + "/page-visit", params, Map.class);
		assertTrue(responseMap.get("pageDailyVisitCount") <= 1);
		assertTrue(responseMap.get("pageDailyUniqueVisitCount") <= 1);
	}

}
