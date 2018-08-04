package com.simulator.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Siddharth
 *
 */
public class SimulatorConstants {

	private SimulatorConstants() {
		throw new IllegalAccessError("Simulator Constant");
	}

	public static final String SIM_SERVER_URL = "ServerUrl";
	public static final String SIM_SERVER_IP = "AppServerIp";
	public static final String SIM_SERVER_PORT = "AppServerPort";
	public static final String SIM_SERVER_TYPE = "AppServerType";
	public static final String SIM_IBPS_APP_CONTEXT_NAME = "simulatorconnect";
	public static final String SIM_IBPS_APP_SERVICE_PREFIX = "api/ibps";
	public static final String SIM_IBPS_APP_API_GET_CABINET_LIST = "fetchCabinetList";
	public static final String SIM_IBPS_APP_API_CONNECT_USER = "connectUser";
	public static final String SIM_IBPS_APP_API_DISCONNECT_USER = "disconnectUser";
	public static final String SIM_IBPS_APP_API_GET_PROJECTS = "fetchProjectList";
	public static final String SIM_IBPS_APP_API_GET_PROCESSES = "fetchProcessList";
	public static final String SIM_IBPS_APP_API_GET_PROCESS = "fetchProcessData";
	public static final String SIM_IBPS_APP_API_GET_PROCESS_CALENDAR = "fetchCalendarList";
	public static final String SIM_IBPS_VALIDATE_SESSION = "validateSession";
	public static final String SIM_IBPS_CHANGE_SECRET = "changePassword";
	public static final String SIM_IBPS_STATUS_NO = "N";
	public static final String SIM_IBPS_STATUS_YES = "Y";
	public static final String SIM_IBPS_PROJECTS_ALL = "A";
	public static final String SIM_IBPS_PROCESSES_ALL = "A";
	public static final String SIM_IBPS_PROCESSES_LOCAL = "L";
	public static final String SIM_DATE_FORMAT_GMT = "yyyy/MM/dd hh:mm:ss a";
	public static final String SIM_DATE_FORMAT_GMT_RULE = "yyyy/MM/dd";
	public static final String SIM_DATE_FORMAT_ORACLE = "yyyy/MM/dd HH:mm:ss";
	public static final String SIM_WORKING_MODE_WORKING = "W";
	public static final String SIM_WORKING_MODE_NON_WORKING = "N";
	public static final String SIM_WORKING_MODE_LEAVE = "L";
	public static final String SIM_DAY_TYPE_ALL_WORKING = "1";
	public static final String SIM_DAY_TYPE_ALL_DAY = "0";
	public static final String SIM_DAY_TYPE_NONE = null;
	public static final String SIM_PAGINATION_SORT_ORDER_ASCENDING = "ASC";
	public static final String SIM_PAGINATION_SORT_ORDER_DESCENDING = "DESC";
	public static final int SIM_PAGINATION_DEFAULT_OFFSET = 0;
	public static final int SIM_PAGINATION_DEFAULT_LIMIT = 10;
	public static final String SIM_ENTITY_TYPE_CALENDAR = "CALENDAR";
	public static final String SIM_ENTITY_TYPE_ROLE = "ROLE";
	public static final String SIM_ENTITY_TYPE_RESOURCE = "RESOURCE";
	public static final String SIM_ENTITY_TYPE_RESOURCE_GROUP = "RESOURCE_GROUP";
	public static final String SIM_ENTITY_TYPE_GROUP = "GROUP";
	public static final String SIM_ENTITY_TYPE_PROJECT = "PROJECT";
	public static final String SIM_ENTITY_TYPE_PROCESS = "PROCESS";
	public static final String SIM_ENTITY_TYPE_SCENARIO = "SCENARIO";
	public static final String SIM_ENTITY_TYPE_SCENARIO_SORT_RECENT_COLUMN_NAME = "modifiedOn";
	public static final String CALENDAR_SAVE_MODE_SIMULATOR = "SIMULATOR";
	public static final String CALENDAR_SAVE_MODE_IBPS = "IBPS";
	public static final String CALENDAR_TYPE_IBPS = "I";
	public static final String DEFAULT_ID_FOR_CUSTOM_CALENDAR = "-1";

	private static final List<String> DECISION_ACTIVITIES = new ArrayList<String>(Arrays.asList("71"));

	public static List<String> getDecisionActivities() {
		return DECISION_ACTIVITIES;
	}

	private static final List<String> USER_ACTIVITIES = new ArrayList<String>(Arrays.asList("11", "13", "103", "321", "106"));

	public static List<String> getUserActivities() {
		return USER_ACTIVITIES;
	}

	private static final List<String> END_ACTIVITIES = new ArrayList<String>(Arrays.asList("21", "22", "31"));

	public static List<String> getEndActivities() {
		return END_ACTIVITIES;
	}

	private static final List<String> DISCARD_ACTIVITIES = new ArrayList<String>(Arrays.asList("31"));

	public static List<String> getDiscardActivities() {
		return DISCARD_ACTIVITIES;
	}

	private static final List<String> SYSTEM_ACTIVITIES = new ArrayList<String>(Arrays.asList("12", "41", "104", "101", "181", "191", "201",
			"211", "221", "261", "271", "291", "301", "311", "331", "231", "251", "241"));

	public static List<String> getSystemActivities() {
		return SYSTEM_ACTIVITIES;
	}

	private static final List<String> QUERY_ACTIVITIES = new ArrayList<String>(Arrays.asList("111"));

	public static List<String> getQueryActivities() {
		return QUERY_ACTIVITIES;
	}

	private static final List<String> BY_PASS_URLS = new ArrayList<String>(Arrays.asList("user/authenticateUser"));

	public static List<String> getByPassUrls() {
		return BY_PASS_URLS;
	}

	private static final List<String> DISTRIBUTE_ACTIVITIES = new ArrayList<String>(Arrays.asList("51", "52"));

	public static List<String> getDistributeActivities() {
		return DISTRIBUTE_ACTIVITIES;
	}

	private static final List<String> COLLECT_ACTIVITIES = new ArrayList<String>(Arrays.asList("61", "62"));

	public static List<String> getCollectActivities() {
		return COLLECT_ACTIVITIES;
	}

	public static final String ENCODING_UTF_8 = "UTF-8";
	public static final String REQUESTSCOPEINFO = "RequestScopeInfo";
	public static final String METHOD_POST = "POST";
	public static final String METHOD_PUT = "PUT";
	public static final String HEADER_ACCESS_CONTROL_ALLOW_CREDENTIALS = "Access-Control-Allow-Credentials";
	public static final String STR_FALSE = "false";
	public static final String STR_TRUE = "true";
}
