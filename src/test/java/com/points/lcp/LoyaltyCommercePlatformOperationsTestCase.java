package com.points.lcp;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Test;
import org.mule.functional.junit4.MuleArtifactFunctionalTestCase;

public class LoyaltyCommercePlatformOperationsTestCase extends MuleArtifactFunctionalTestCase {

	/**
	 * Specifies the mule config xml with the flows that are going to be executed in
	 * the tests, this file lives in the test resources.
	 */
	@Override
	protected String getConfigFile() {
		return "test-mule-config.xml";
	}

	@Test
	public void executeMemberValidationOperation() throws Exception {
		Integer payloadValue = ((Integer) flowRunner("validateMemberFlow").run().getMessage().getPayload().getValue());
		assertThat(payloadValue, is(1234));
	}
	
	@Test
	public void executeGetMemberDetailsOperation() throws Exception {
		Integer payloadValue = ((Integer) flowRunner("getMemberDetailsFlow").run().getMessage().getPayload().getValue());
		assertThat(payloadValue, is(1234));
	}
	
	@Test
	public void executeCreditMemberAccountOperation() throws Exception {
		String payloadValue = ((String) flowRunner("creditMemberAccountFlow").run().getMessage().getPayload().getValue());
		assertThat(payloadValue, is("complete"));
	}
	
	@Test
	public void executDebitMemberAccountOperation() throws Exception {
		String payloadValue = ((String) flowRunner("debitMemberAccountFlow").run().getMessage().getPayload().getValue());
		assertThat(payloadValue, is("complete"));
	}

}
