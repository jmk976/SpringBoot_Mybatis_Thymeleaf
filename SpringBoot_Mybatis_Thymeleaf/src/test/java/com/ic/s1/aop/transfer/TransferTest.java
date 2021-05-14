package com.ic.s1.aop.transfer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TransferTest {

	@Autowired
	private Transfer transfer;
	
	@Autowired
	private Card card;
	
	
	
	@Test
	void test() {
	
		transfer.takeBus();

		transfer.takeSubway();

	}
	
	
	
	
	
}
