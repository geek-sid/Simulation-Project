package com.simulator.rest;

import java.util.ArrayList;
import java.util.List;

import com.simulator.utils.WSConstants.WSExceptionConstant;

public class ValidationResult {
	private List<WSExceptionConstant> messages = null;
	private String messageSeparator = " :: ";
	
	public ValidationResult(){
		messages = new ArrayList<WSExceptionConstant>();
	}
	
	public void addMessage(WSExceptionConstant message){
		messages.add(message);
	}
	
	public boolean isValid(){
		if(messages !=null && !messages.isEmpty())
			return false;
		return true;
	}
	public String getMessage(){
		StringBuilder sb = new StringBuilder();
		if(isValid())
			return null;
		
		boolean separatorFlag = false;
		
		for(WSExceptionConstant message : messages){
			if(separatorFlag)
				sb.append(messageSeparator);
			
			sb.append(message.getValue());
			separatorFlag = true;
		}
		
		if (sb.length() > 0)
			return sb.toString();
		return null;
	}

	/**
	 * @return the messages
	 */
	public List<WSExceptionConstant> getMessages() {
		return messages;
	}

	/**
	 * @param messages the messages to set
	 */
	public void setMessages(List<WSExceptionConstant> messages) {
		this.messages = messages;
	}
	
	
}
