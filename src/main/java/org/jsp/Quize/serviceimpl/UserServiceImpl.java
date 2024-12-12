package org.jsp.Quize.serviceimpl;

import org.jsp.Quize.Questiondao.UserDao;
import org.jsp.Quize.entity.User;
import org.jsp.Quize.responseStructure.ResponseStructure;
import org.jsp.Quize.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao dao;

	@Override
	public ResponseEntity<?> saveUser(User user) {
		user=dao.saveUser(user);
		return ResponseEntity.status(HttpStatus.OK.value()).body(ResponseStructure.builder().httpStatus(HttpStatus.OK.value()).message("User Saved Successfully").body(user).build());
	}

	
}
