package com.form.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.form.service.ProductService;
import com.form.viewBean.ProductBean;

@Controller
public class ProductController {
	@Autowired
	private ProductService prodService;

	@RequestMapping(value = "list/{id}", method = RequestMethod.GET)
	public ModelAndView displayProductList(HttpServletResponse response, @PathVariable int id) throws SQLException {
		ModelAndView model = new ModelAndView();
		List<ProductBean>productBean = prodService.productList(id);

		if (productBean != null) {
			model.setViewName("list");
			model.addObject("list", productBean);
		}
		return model;
	}

	@RequestMapping(value = "productDetail/{id}", method = RequestMethod.GET)
	public ModelAndView showdescription(HttpServletResponse response, @PathVariable int id) throws SQLException {
		ModelAndView model = new ModelAndView();
		ProductBean productBean = prodService.getdescription(id);

		if (productBean != null) {
			model.setViewName("productDetail");
			model.addObject("info", productBean);
		}
		return model;

	}
}
