package org.jsp.Quize.controler;

import org.jsp.Quize.entity.User;
import org.jsp.Quize.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Controller
@RequestMapping("/users")
public class UserControler {
	@Autowired
	private UserService service;

	@PostMapping
	public ResponseEntity<?> saveUser(@RequestBody User user) {
		return service.saveUser(user);
	}

	@GetMapping("/login")
	public void userLogin(@PathVariable int id, @PathVariable String password) {
		return service.userLogin(id, password);
	}
}
