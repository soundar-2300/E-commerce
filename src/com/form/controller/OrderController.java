package com.form.controller;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

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
import org.springframework.web.portlet.ModelAndView;

import com.form.service.CartService;
import com.form.service.OrderService;
import com.form.service.UserService;
import com.form.viewBean.CartBean;
import com.form.viewBean.OrderBean;
import com.form.viewBean.UserBean;

@Controller
public class OrderController {

	@Autowired
	private OrderService orderService;

	String email = "gokul@gmail.com";

	@RequestMapping(value = "/checkout", method = RequestMethod.GET)
	public String Showdetail(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("dispatch") UserBean user, OrderBean order, Model model) throws SQLException {

		UserBean proof = orderService.ordercheckout(email);
		if (proof != null) {
			model.addAttribute("userBean", proof);
			return "checkout";
		} else {
			request.setAttribute("message", " your page expired try again");
			return "redirect:/cartPage";
		}

	}

	@SuppressWarnings("unused")
	@RequestMapping(value = "/payment", method = RequestMethod.GET)
	public String showPayment(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("orderBean1") CartBean OrderBean1, Model model) throws SQLException {

		CartBean orderBean1 = orderService.totalpayment(email);
		orderBean1.setDatetime(Timestamp.valueOf(LocalDateTime.now()));

		if (orderBean1 != null) {
			model.addAttribute("orderBean", orderBean1);
			model.addAttribute("userBean", orderBean1);
			return "payment";
		} else {
			request.setAttribute("message", " your page expired try again");
			return "redirect:/checkout";

		}

	}

	/*
	 * @RequestMapping(value="/summary1",method=RequestMethod.GET) public String
	 * showsummary1(HttpServletRequest request, HttpServletResponse
	 * response,@ModelAttribute("orderBean1")OrderBean orderBean, Model model)
	 * throws SQLException { orderBean =orderService.getDetailSummary(email);
	 * 
	 * if(orderBean!=null) { model.addAttribute("orderBean", orderBean);
	 * return"summary1"; }else { return"payment"; } }
	 */

	@RequestMapping(value = "/ saved ", method = RequestMethod.POST)
	public ModelAndView datasStoraged(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("orderBean1") @Valid OrderBean orderBean1, BindingResult result) throws SQLException {
		ModelAndView model = new ModelAndView();
		orderBean1.setDatetime(Timestamp.valueOf(LocalDateTime.now()));
		boolean orderBean2 = orderService.submitdatas(orderBean1);
		if (orderBean2) {
			model.setViewName("saved");
			model.addObject("orderBean", orderBean2);
			model.addObject("userBean", orderBean2);
			request.setAttribute("email", orderBean1.getEmail());
			model.addObject("msg", "entered the details saved successfully");

		} else {
			model.addObject("payment");
		}
		return model;
	}

	@RequestMapping(value = "/summary1", method = RequestMethod.GET)
	public String showsummeray(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("orderBean1") OrderBean orderBean1, Model model) throws SQLException {

		orderBean1 = orderService.getDetailSummary(email);
		if (orderBean1 != null) {

			model.addAttribute("orderBean", orderBean1);
			model.addAttribute("userBean", orderBean1);
			return "summary1";
		} else {
			request.setAttribute("message", "your summary is not completed");
			return "redirect:/payment";

		}
	}

}
