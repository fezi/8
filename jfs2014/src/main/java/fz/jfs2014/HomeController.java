package fz.jfs2014;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	private static final Logger log = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	protected UserRepo userRepo;

	@RequestMapping("/")
	public ModelAndView root() {
		log.info("render form");
		return new ModelAndView("home.jsp");
	}

}