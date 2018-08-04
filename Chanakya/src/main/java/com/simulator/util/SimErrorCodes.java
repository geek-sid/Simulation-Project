package com.simulator.util;

/**
 * error codes and messages sent in the REST API responses.
 * 
 * @author harshil.sharma
 *
 */
public class SimErrorCodes {

	
	public static final String UNSUPPORTED_REQUEST_CONTENT_TYPE = "SIM-001";
	public static final String UNSUPPORTED_REQUEST_CONTENT_TYPE_MESSAGE = "Unsupported requested content type";
	public static final String INVALID_REQUEST_PAYLOAD_STRUCTURE = "SIM-002";
	public static final String INVALID_REQUEST_PAYLOAD_STRUCTURE_MESSAGE = "Invalid request payload structure";
	public static final String INVALID_SERVICE_REQUEST = "SIM-003";
	public static final String INVALID_SERVICE_REQUEST_MESSAGE = "Invalid service request";
	public static final String INVALID_REQUEST_PARAMETERS = "SIM-004";
	public static final String SERVER_ERROR = "SIM-005";
	public static final String SERVER_ERROR_MESSAGE = "Failed to process request";
	public static final String SAVE_SCENARIO_FAILED = "SIM-006";
	public static final String SAVE_SCENARIO_FAILED_MESSAGE = "Failed to save the Scenario";
	public static final String GET_PROJECTS_FAILED = "SIM-007";
	public static final String GET_PROJECTS_FAILED_MESSAGE = "Failed to load the projects";
	public static final String INVALID_REQUEST_PARAMETERS_MESSAGE = "Invalid request parameter";
	public static final String INVALIDCREDENTAIL_MESSAGE = "Invalid username or password";
	public static final String INVALID_REQUEST_MESSAGE = "INVALID_REQUEST";
	public static final String CHANGE_STRING_DATE_FORMAT_FAILED_MESSAGE = "Failed to convert String to Date";
	public static final String CONSTRAINT_VOILATION_ERROR = "Constraint voilation error.";
}
