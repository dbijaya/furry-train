package com.bijay.springbootjpa.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

//@Controller
@RestController
//@RequestMapping("/")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET, produces = "text/html")
	public String indexView(ModelMap model) {
		String message = "Hello Spring-Boot with JSP View !!";
		model.put("message", message);
		return "index";
	}

	@RequestMapping(value = "/userList", method = RequestMethod.GET, produces= "text/html")
	public String viewUserList(ModelMap model) {
		List<User> allUsers = userService.getAllUsers();
//    	model.addAllAttributes("allUsers", allUsers);
		model.put("allUsers", allUsers);
		return "userList";
	}

	@RequestMapping("/api/users")
	public List<User> getAllUsers(ModelMap model) {
		return userService.getAllUsers();
	}

	@RequestMapping("/api/users/{id}")
	public Optional<User> getUser(@PathVariable Integer id) {
		return userService.getUser(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/api/users")
	public String addUser(@RequestBody User user) {
		userService.addUser(user);
		return String.format("User: '%s' - added successfully.", user.getName());
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/api/users/{id}")
	public String updateUser(@RequestBody User user, @PathVariable Integer id) {
		userService.updateUser(user, id);
		return String.format("User: '%s' - updated successfully.", user.getName());
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/api/users/{id}")
	public String userDelete(@PathVariable Integer id) {
		userService.deleteUser(id);
		return String.format("User of id: '%d' - deleted.", id);
	}

}
