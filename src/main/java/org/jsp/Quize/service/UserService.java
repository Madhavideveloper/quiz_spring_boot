package org.jsp.Quize.service;

import org.jsp.Quize.entity.User;
import org.springframework.http.ResponseEntity;

public interface UserService {

	ResponseEntity<?> saveUser(User user);

	Object userLogin(int id, String password);

	

}
