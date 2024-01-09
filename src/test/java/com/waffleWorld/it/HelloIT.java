package com.waffleWorld.it;

import org.junit.Before;
import org.junit.Test;

public class HelloIT{
	
	private static String port, name;
	
	@Before
	public void setup() {
		port = System.getProperty("servlet.port", "9090");
	}

	@Test
	public void hello() {
		
	}

}
