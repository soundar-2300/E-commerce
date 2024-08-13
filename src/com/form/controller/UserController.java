
package com.form.controller;

import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.form.dao.impl.UserDaoImpl;
import com.form.service.UserService;
import com.form.validator.UserValidator;
import com.form.viewBean.UserBean;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserValidator userValid;

	String email = "gokul@gmail.com";
			
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView Logindisplay(HttpServletRequest request, HttpServletResponse response, UserBean userBean) {
		ModelAndView model = new ModelAndView();
	model.addObject("userBean", userBean);
		model.setViewName("userLogin");

		return model;
	}
	@RequestMapping(value = "/userLogin", method = RequestMethod.POST)
	public String UserLogindisplay(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("userBean") @Valid UserBean userBean, BindingResult result, Model model)
			throws SQLException {

	UserBean isValidUser = userService.isValidUser(email);
		if (isValidUser!=null) {
			model.addAttribute("userBean", isValidUser);
		request.setAttribute("email", userBean.getEmail());
			return "redirect:/home";
		} else {
			request.setAttribute("message", "Email-Id or password is invalid");
			return "login";
		}
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView Login(HttpServletRequest request, HttpServletResponse response, UserBean userBean) {
		ModelAndView model = new ModelAndView();
	model.addObject("userBean", userBean);
		//model.setViewName("login");

		return model;
	}
	

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String UserLogin(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("userBean") @Valid UserBean userBean, BindingResult result, Model model)
			throws SQLException {

	UserBean isValidUser = userService.isValidUser(email);
		if (isValidUser!=null) {
			model.addAttribute("userBean", isValidUser);
		request.setAttribute("email", userBean.getEmail());
			return"profile	";
			//return "redirect:/home";
		} else {
			request.setAttribute("message", "Email-Id or password is invalid");
			return "login";
		}
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView register(HttpServletRequest request, HttpServletResponse response, UserBean userBean) {
		ModelAndView model = new ModelAndView("register");
		model.addObject("userBean", userBean);
		return model;
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String userRegister(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("userBean") @Valid UserBean userBean, BindingResult result, Model model)
			throws SQLException {

		userValid.validate(userValid, result);
		if (result.hasErrors()) {
			model.addAttribute("message", "Please Enter Valid details :-( ");
			return "register";
		}
		if (UserDaoImpl.existsEmail(userBean.getEmail())) {
			return "register";
		}
		if (!userBean.getPassword().equals(userBean.getConfirmPassword())) {
			model.addAttribute("message", "Password MissMatch :-{");
			return "register";
		} else {
			model.addAttribute(userService.addUser(userBean));
			model.addAttribute("message", "Details Registered Successfully :-) ");
			return "regmsg";
		}
	}

	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public ModelAndView displayProfile(HttpServletRequest request, HttpServletResponse response,
			@RequestParam String email, UserBean userBean) {

		ModelAndView model = new ModelAndView();
		UserBean userDetail;
		try {
			userDetail = userService.userInfo(email);

			

			if (userDetail != null) {
				model = new ModelAndView("profile");
				model.addObject("userBean", userDetail);
				request.setAttribute("userBean", model);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String editUsers(HttpServletRequest request, HttpServletResponse response,
			@RequestParam @ModelAttribute("userBean") UserBean userBean, Model model) {

		UserBean userDetail;
		try {
			userDetail = userService.userInfo(email);

			if (userDetail != null) {
				model.addAttribute("edit");
				model.addAttribute("userBean", userDetail);
				return "redirect:/edit";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "profile";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView executeUpdate(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("userBean") UserBean userBean, BindingResult result) {
		ModelAndView model = null;
		try {
			boolean updateDetails = userService.editUser(userBean);

			if (updateDetails) {
				model = new ModelAndView("profile");
				model.addObject("message", "User Details Updated Successfully");
				request.setAttribute("email", userBean.getEmail());
			} else {
				model = new ModelAndView("edit");
				model.addObject("message", "Details Not Updated Successfully");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public ModelAndView displayDetails(HttpServletRequest request, HttpServletResponse response,
			@RequestParam UserBean userBean) {

		ModelAndView model = new ModelAndView();
		try {
			UserBean Detail = userService.userInfo(email);
			if (Detail != null) {
				model = new ModelAndView("update");
				model.addObject("userBean", Detail);
				request.setAttribute("userBean", model);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}

	@RequestMapping(value = "profile/edit", method = RequestMethod.GET)
	public ModelAndView userupdate(HttpServletRequest request, HttpServletResponse response,
		@ModelAttribute("orderBean1") UserBean orderBean1, String email,BindingResult result) throws SQLException {
		ModelAndView model = null;
		try {
			UserBean updateDetails = userService.userInfo(email);

			if (updateDetails != null) {
				model = new ModelAndView("edit");
				model.addObject("userBean", updateDetails);

				request.setAttribute("email", orderBean1.getEmail());
			} else {
				model = new ModelAndView("checkout");
				model.addObject("message", "Details Not Updated Successfully");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}

	
		@RequestMapping(value = "/updateaddress", method = RequestMethod.POST)
	public ModelAndView editUser(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("orderBean1") UserBean orderBean1, BindingResult result) throws SQLException {

		ModelAndView model =new ModelAndView();

			boolean proof = userService.editUser(orderBean1);

			if (proof) {
			
				model.setViewName("updateaddress");
				request.setAttribute("email", orderBean1.getEmail());
				model.addObject("message", "User Details Updated Successfully");

			}else {
				model = new ModelAndView("editaddress");
				model.addObject("message", "Details Not Updated Successfully");
			
		} 
	
		return model;
	}

		@RequestMapping(value = "/checkout1", method = RequestMethod.GET)
		public ModelAndView updateaddress(HttpServletRequest request, HttpServletResponse response,
				@RequestParam UserBean orderBean1) {

			ModelAndView model = null;
			try {
				UserBean Detail = userService.userInfo(email);
				if (Detail != null) {
					model = new ModelAndView("checkout1");
					model.addObject("userBean", Detail);
					request.setAttribute("email", orderBean1.getEmail());		
					request.setAttribute("userBean", model);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return model;
		}


	/*
	 * boolean isValidUser = userService.editAddress(orderBean1); if (isValidUser) {
	 * request.setAttribute("email", orderBean1.getEmail()); return "checkout"; }
	 * else { request.setAttribute("message", "Email-Id or password is invalid");
	 * return "editAddress"; } }
	 */

}