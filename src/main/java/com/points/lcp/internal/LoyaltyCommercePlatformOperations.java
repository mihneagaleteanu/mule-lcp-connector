package com.points.lcp.internal;

import org.mule.runtime.extension.api.annotation.param.Config;
import org.mule.runtime.extension.api.annotation.param.Connection;
import org.mule.runtime.extension.api.annotation.param.MediaType;
import org.mule.runtime.extension.api.annotation.param.Optional;

/**
 * This class is a container for operations, every public method in this class
 * will be taken as an extension operation.
 */
public class LoyaltyCommercePlatformOperations {

	@MediaType(value = MediaType.APPLICATION_JSON, strict = false)
	public String validateMemberAccount(@Config LoyaltyCommercePlatformConfiguration configuration, String memberId,
			String firstName, String lastName, @Optional String password,
			@Connection LoyaltyCommercePlatformConnection connection) {
		String request = "{\"memberId\": \"" + memberId + "\",\"firstName\":\"" + firstName + "\",\"lastName\":\""
				+ lastName + "\"}";
		try {
			return connection.callLCP(request, "mvs");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@MediaType(value = MediaType.APPLICATION_JSON, strict = false)
	public String getMemberDetails(@Config LoyaltyCommercePlatformConfiguration configuration, String memberValidation,
			@Connection LoyaltyCommercePlatformConnection connection) {
		String fullUrl = memberValidation + "/member-details";
		try {
			return connection.callLCPGet(fullUrl);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Example of a simple operation that receives a string parameter and returns a
	 * new string message that will be set on the payload.
	 */
	@MediaType(value = MediaType.APPLICATION_JSON, strict = false)
	public String debitMemberAccount(@Config LoyaltyCommercePlatformConfiguration configuration,
			String memberValidation, String pic, int amount, @Connection LoyaltyCommercePlatformConnection connection) {
		String request = "{\"memberValidation\": \"" + memberValidation + "\",\"amount\":" + amount + ",\"pic\":\""
				+ pic + "\"}";
		try {
			return connection.callLCP(request, "debit-order");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@MediaType(value = MediaType.APPLICATION_JSON, strict = false)
	public String creditMemberAccount(@Config LoyaltyCommercePlatformConfiguration configuration,
			String memberValidation, String pic, int amount, @Connection LoyaltyCommercePlatformConnection connection) {
		String request = "{\"memberValidation\": \"" + memberValidation + "\",\"amount\":" + amount + ",\"pic\":\""
				+ pic + "\"}";
		try {
			return connection.callLCP(request, "credit-order");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
