package org.jsp.Quize.repositary;

import java.util.List;

import org.jsp.Quize.entity.Question;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

@Component
public interface QuestionRepositary extends JpaRepository<Question, Integer> {
	@Query("select q from Question q where q.status='ACTIVE'")
	List<Question> findAllActiveQuestions();
	
	
//	@Query("select q from Question q ORDER BY FUNCTION('RAND')ASC");
//	List<Question> findRandomQuestions(Pageable pageable);

	@Query("select q from Question q ORDER BY FUNCTION('RAND') ASC")
	List<Question> findRandomQuestions(Pageable pageable);

}
