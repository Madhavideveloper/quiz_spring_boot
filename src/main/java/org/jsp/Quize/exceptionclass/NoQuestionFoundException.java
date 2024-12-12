package org.jsp.Quize.exceptionclass;

import lombok.Builder;

@Builder
public class NoQuestionFoundException extends RuntimeException {
private String message;
public NoQuestionFoundException(String message) {
	this.message=message;
}
public NoQuestionFoundException() {
	
}
@Override
public String getMessage() {
	return this.message;
}
}
