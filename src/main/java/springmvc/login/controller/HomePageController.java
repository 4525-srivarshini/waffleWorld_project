package springmvc.login.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import springmvc.login.dao.Authentication;
import springmvc.login.model.User;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class HomePageController {

	@Autowired
	private Authentication userDao;


	@RequestMapping(value = "/loginHome", method = RequestMethod.GET)
	public String userLoginHome(Map<String, Object> model) {
		model.put("homePageModel", new User());
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView userLogin(HttpServletRequest httpServletRequest) {
		ModelAndView mv = new ModelAndView();
		String name = userDao.loginUser(httpServletRequest);
		if (name != null) {
			mv.addObject("msg", "Welcome " + name + ", You have successfully logged in.");
			mv.setViewName("welcome");
		} else {
			mv.addObject("msg", "Invalid user id or password.");
			mv.setViewName("login");
		}
		return mv;
	}
	@RequestMapping(value = "/registerHome", method = RequestMethod.GET)
	public String userRegisterHome(Map<String, Object> model) {
		model.put("homePageModel", new User());
		return "registerHome";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView registerUser(HttpServletRequest httpServletRequest) {
		ModelAndView mv = new ModelAndView();
		int counter = 0;
		counter = userDao.registerUser(httpServletRequest);
		if (counter > 0) {
			mv.addObject("msg", "User registration successful.");
		} else {
			mv.addObject("msg", "Incorrect Registration.");
		}
		mv.setViewName("login");
		return mv;
	}
}
