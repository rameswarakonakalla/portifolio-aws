package com.cognizant.dailymutualfund.exception;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MutualFundNotFoundExceptionTest {

	@Test
	void testMutualFundNotFoundException() {
		MutualFundNotFoundException shareNotFoundException=new MutualFundNotFoundException("Error occured");
		assertEquals("Error occured",shareNotFoundException.getMessage());
	}

}
