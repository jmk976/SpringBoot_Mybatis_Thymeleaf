package com.ic.s1.aop.transfer;

import org.springframework.stereotype.Component;

@Component
public class Transfer {
	
	public String takeSubway() {
		
		System.out.println("get in subway");
		System.out.println("watch netflix");
		return "lind 7!";
	}

	
	public void takeBus() {
		System.out.println("get in bus");
		System.out.println("listen to music");
	}
}
