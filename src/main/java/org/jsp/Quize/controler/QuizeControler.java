package org.jsp.Quize.controler;

import java.security.Provider.Service;
import java.util.List;
import java.util.Random;

import org.jsp.Quize.dto.QuizResponse;
import org.jsp.Quize.entity.Question;
import org.jsp.Quize.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/questions")
public class QuizeControler {

	@Autowired
	private QuestionService service;

	@PostMapping
	public ResponseEntity<?> saveQuestion(@RequestBody Question question) {
		return service.saveQuestion(question);
	}

	@GetMapping
	public ResponseEntity<?> findAllQuestions() {
		return service.findAllQuestions();
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> findQuestionById(@PathVariable int id) {
		return service.findQuestionById(id);
	}

	@GetMapping("/take-quiz")
	public ResponseEntity<?> takeQuiz() {
		return service.takeQuiz();
	}

	// submit-quiz
	@PostMapping("/submit-quiz")
	public ResponseEntity<?> submitQuiz(@RequestBody List<QuizResponse> quizresponses) {
		return service.submitQuiz(quizresponses);
	}

//	@GetMapping("/submit-quiz")
//	public static Question findRandomQuestions(List<Question> questions) {
//		return service.findRandomQuestions();
//	}
	
	
}
