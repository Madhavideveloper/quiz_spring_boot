package org.jsp.Quize.service;

import java.util.List;

import org.jsp.Quize.dto.QuizResponse;
import org.jsp.Quize.entity.Question;
import org.springframework.http.ResponseEntity;

public interface QuestionService {

	ResponseEntity<?> saveQuestion(Question question);

	ResponseEntity<?> findAllQuestions();

	ResponseEntity<?> findQuestionById(int id);

	ResponseEntity<?> takeQuiz();

	ResponseEntity<?> submitQuiz(List<QuizResponse> quizresponses);

	

	



	

	

}
