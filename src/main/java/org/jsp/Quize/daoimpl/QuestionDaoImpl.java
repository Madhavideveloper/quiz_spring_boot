package org.jsp.Quize.daoimpl;

import java.util.List;
import java.util.Optional;

import org.jsp.Quize.Questiondao.QuestionDao;
import org.jsp.Quize.entity.Question;
import org.jsp.Quize.repositary.QuestionRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

@Repository
public class QuestionDaoImpl implements QuestionDao {
	@Autowired
	private QuestionRepositary repositary;

	@Override
	public Question saveQuestion(Question question) {
		return repositary.save(question);
	}


	@Override
	public Optional<Question> findQuestionById(int id) {
	
		return repositary.findById(id);
	}

	
	@Override
	public List<Question> findAllActiveQuestions() {
		
		return repositary.findAllActiveQuestions();
	}


	@Override
	public List<Question> findAllQuestions() {
		
		return repositary.findAll();
	}



	@Override
	public List<Question> findRandomQuestions() {
		return repositary.findRandomQuestions(PageRequest.of(0, 5));
	}

	
	

	

	
	
	
	
	
}
