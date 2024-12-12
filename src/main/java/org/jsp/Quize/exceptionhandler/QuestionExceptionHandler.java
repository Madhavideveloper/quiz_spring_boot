package org.jsp.Quize.exceptionhandler;

import org.jsp.Quize.exceptionclass.InvaliQuestionIdException;
import org.jsp.Quize.exceptionclass.NoQuestionFoundException;
import org.jsp.Quize.responseStructure.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class QuestionExceptionHandler {
	@ExceptionHandler(NoQuestionFoundException.class)
   public ResponseEntity<?> noQuestionFoundExceptionHandler(NoQuestionFoundException e){
//		ResponseStructure<String> rs=new ResponseStructure<String>();
//		rs.setHttpStatus(0);
//		rs.setBody(null);
//		rs.setMessage("not found");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ResponseStructure.builder().httpStatus(HttpStatus.NOT_FOUND.value()).message("no question in the database table").body("no question found").build());
	 
   }
	@ExceptionHandler(InvaliQuestionIdException.class)
	public ResponseEntity<?> invaliQuestionIdExceptionHandler(InvaliQuestionIdException e){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ResponseStructure.builder().httpStatus(HttpStatus.NOT_FOUND.value()).message("inavali question id").body("id is not present").build());
	}
}
