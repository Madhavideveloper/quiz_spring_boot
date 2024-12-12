package org.jsp.Quize.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.jsp.Quize.Questiondao.QuestionDao;
import org.jsp.Quize.dto.QuestionDto;
import org.jsp.Quize.dto.QuizResponse;
import org.jsp.Quize.dto.TakeQuiz;
import org.jsp.Quize.entity.Question;
import org.jsp.Quize.exceptionclass.InvaliQuestionIdException;
import org.jsp.Quize.exceptionclass.NoQuestionFoundException;
import org.jsp.Quize.responseStructure.ResponseStructure;
import org.jsp.Quize.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class QuestionServiceImpl implements QuestionService {
	@Autowired
	private QuestionDao dao;

	@Override
	public ResponseEntity<?> saveQuestion(Question question) {
		question = dao.saveQuestion(question);
//		ResponseStructure<Question> structure=new ResponseStructure<>();
//		structure.setHttpStatus(HttpStatus.CREATED.value());
//		structure.setMessage("question saved..");
//		structure.setBody(question);
//		return new ResponseEntity<>(structure,HttpStatus.CREATED);
		return ResponseEntity.status(HttpStatus.OK.value()).body(ResponseStructure.builder()
				.httpStatus(HttpStatus.OK.value()).message("question added suceessfully").body(question).build());
	}

	@Override
	public ResponseEntity<?> findAllQuestions() {

		List<Question> questions = dao.findAllActiveQuestions();
		List<QuestionDto> dtolist = new ArrayList<>();
		for (Question q : questions) {
			dtolist.add(new QuestionDto(q.getTittle(), q.getA(), q.getB(), q.getC(), q.getD()));
		}
		if (dtolist.isEmpty()) {
			throw NoQuestionFoundException.builder().message("no data found in data base").build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().httpStatus(HttpStatus.OK.value())
				.message("data found").body(questions).build());

	}

	@Override
	public ResponseEntity<?> findQuestionById(int id) {
		Optional<Question> optional = dao.findQuestionById(id);
		if (optional.isEmpty()) {
			throw InvaliQuestionIdException.builder().message("invalid id").build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().httpStatus(HttpStatus.OK.value())
				.message("id not found").body(optional.get()).build());
	}

	@Override
	public ResponseEntity<?> takeQuiz() {
		 List<Question> randomQuestions = dao.findRandomQuestions();
		List<TakeQuiz> dtolist = new ArrayList<>();
		for (Question q : randomQuestions) {
			dtolist.add(new TakeQuiz(q.getId(), q.getTittle(), q.getA(), q.getB(), q.getC(), q.getD()));
		}
		if (dtolist.isEmpty()) {
			throw NoQuestionFoundException.builder().message("No questions to take quiz").build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().httpStatus(HttpStatus.OK.value())
				.message(" ques foun").body(dtolist).build());

	}

	@Override
	public ResponseEntity<?> submitQuiz(List<QuizResponse> quizresponses) {
		int c=0;
		for(QuizResponse qr:quizresponses) {
			 Optional<Question>q=dao.findQuestionById(qr.getId());
			if(q.isEmpty()) {
				throw InvaliQuestionIdException.builder().message("invalid question id unable to find id").build();
			}
			Question question =q.get();
			if(question.getAns().equalsIgnoreCase(qr.getAns())) {
				c++;
			}
		}
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().httpStatus(HttpStatus.OK.value())
				.message("submision successfull").body("your score" + c).build());
	}



}
