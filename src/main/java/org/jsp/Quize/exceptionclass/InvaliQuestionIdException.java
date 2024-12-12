package org.jsp.Quize.exceptionclass;

import lombok.Builder;

@Builder
public class InvaliQuestionIdException extends RuntimeException{
	private String message;
	public InvaliQuestionIdException(String message) {
		this.message=message;
	}
	public InvaliQuestionIdException() {
		
	}
	@Override
	public String getMessage() {
		return this.message;
	}

}
