package org.jsp.Quize.daoimpl;

import org.jsp.Quize.Questiondao.UserDao;
import org.jsp.Quize.entity.User;
import org.jsp.Quize.repositary.UserRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	private UserRepositary repositary;

	@Override
	public User saveUser(User user) {
		return repositary.save(user);
	}

}
