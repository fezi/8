package fz.jfs2014;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.google.common.collect.Lists;

@RestController
public class UserController {

	private static final Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	protected UserRepo userRepo;

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public User write(@RequestParam(value = "name", required = false, defaultValue = "") String name,
			@RequestParam String email, @RequestParam String password) {
		User user = new User();
		user.setName(name);
		user.setPassword(password);
		user.setEmail(email);
		user = userRepo.save(user);
		log.info("created {}", user);
		return user;
	}

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public List<User> list() {
		log.info("list all users");
		return Lists.newArrayList(userRepo.findAll());
	}

	@RequestMapping("/user/{userId}")
	public User read(@PathVariable long userId) {
		log.info("return single user {}", userId);
		return userRepo.findOne(userId);
	}

	@RequestMapping("/")
	public String root() {
		log.info("render form");
		return "<html><body><form method='post' action='/user'>"
				+ "Name: <input name='name'/><br/>E-Mail: <input name='email' type='email' value='default@email'/><br/> "
				+ "Passwort: <input name='password' type='password'  value='password'/><br/>"
				+ "<input type='submit' value='create'/>" + "</form><a href='/user'>to user list</a></body></html>";
	}

}