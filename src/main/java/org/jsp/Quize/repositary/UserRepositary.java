package org.jsp.Quize.repositary;

import org.jsp.Quize.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositary extends JpaRepository<User, Integer> {

	User save(org.jsp.Quize.entity.User user);

}
