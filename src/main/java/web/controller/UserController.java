package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.service.UserService;

@Controller
public class UserController {

	private UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	public UserController() {
	}

	@GetMapping("/users")
	public String printUsers(Model model) {
		model.addAttribute("user", userService.getUsers());
		return "/users";
	}

	@GetMapping("/users/{id}")
	public String show(@PathVariable("id") int id, Model model) {
		model.addAttribute("user", userService.getUserById(id));
		return "/user";
	}
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage() {
		return "/login";
	}
}