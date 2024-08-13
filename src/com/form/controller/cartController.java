package com.form.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.form.service.CartService;
import com.form.viewBean.AddToCartFrom;
import com.form.viewBean.CartBean;
import com.form.viewBean.CartEntryBean;
import com.form.viewBean.ProductBean;
import com.form.viewBean.UserBean;

@Controller
public class cartController {

	@Autowired
	CartService cartService;

	String email ="gokul@gmail.com";
			 
	
			

	@RequestMapping(value = "/addToCart", method = RequestMethod.POST)
	public String displaycartPage(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("form") AddToCartFrom add) throws SQLException {
		boolean cartBean = cartService.addToCart(add);

		if (cartBean) {
			return "redirect:/showCart";
		} else {
			return "redirect:/productDetail";
		}

	}

	@RequestMapping(value = "/showCart", method = RequestMethod.GET)
	public String displayshowcart(HttpServletRequest request, HttpServletResponse response, CartBean Bean, Model model)
			throws SQLException {

		CartBean data = cartService.getCartdetails(email);

		if (data != null) {
			model.addAttribute("files", data);		
			return "cartPage";
		} else {
			request.setAttribute("message", " your page expired try again");
			return "redirect:/productDetail";
		}
	}

	@RequestMapping(value = "/updateQuantity", method = RequestMethod.POST)
	public String updateproduct(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("update") CartEntryBean cartEntryBean) throws SQLException {

		boolean updateQuantity = cartService.updateQuantity(cartEntryBean);
		if (updateQuantity) {
			return "redirect:/showCart";
		} else {
			return "redirect:/showCart";
		}
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String removeproduct(HttpServletResponse response, @ModelAttribute("delete")  CartEntryBean bean,Integer Id)
			throws SQLException {
		boolean cartBean = cartService.getdeleteprocess(Id);
		
		if (cartBean) {

			return "redirect:/showCart";
		} else {
			return "redirect:/showCart";
		}

	}
	}



