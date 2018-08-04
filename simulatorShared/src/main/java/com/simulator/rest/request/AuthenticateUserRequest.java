package com.simulator.rest.request;

import javax.xml.bind.annotation.XmlRootElement;

import com.simulator.rest.ValidationResult;
import com.simulator.rest.WSRequest;
import com.simulator.utils.WSConstants;

@XmlRootElement
public class AuthenticateUserRequest implements WSRequest {

	String username;
	String authpwd;
	String userType;

	public AuthenticateUserRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAuthpwd() {
		return authpwd;
	}

	public void setAuthpwd(String authpwd) {
		this.authpwd = authpwd;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	@Override
	public String toString() {
		return "Authenticate User Request :: [ " + username + "  ,userType   " + userType + "  ]";
	}

	public ValidationResult validate() {
		ValidationResult validationResult = new ValidationResult();
		if (username == null || WSConstants.EMPTY_STRING.equalsIgnoreCase(username)) {
			validationResult.addMessage(WSConstants.WSExceptionConstant.USERNAME_CANNOT_BE_BLANK);
		} else if (authpwd == null || WSConstants.EMPTY_STRING.equalsIgnoreCase(authpwd)) {
			validationResult.addMessage(WSConstants.WSExceptionConstant.PASSWORD_CANNOT_BE_BLANK);
		} else if (userType == null || WSConstants.EMPTY_STRING.equalsIgnoreCase(userType)) {
			validationResult.addMessage(WSConstants.WSExceptionConstant.USERTYPE_CANNOT_BE_BLANK);
		}
		return validationResult;
	}

}
