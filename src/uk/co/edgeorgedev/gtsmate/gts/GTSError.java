package uk.co.edgeorgedev.gtsmate.gts;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class GTSError {
	
	private String message;
	private String code;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}	
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
}
