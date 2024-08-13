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

import com.form.service.RedkartService;
import com.form.viewBean.KartBean;

@Controller
public class CategoryController {

	@Autowired
	private RedkartService kartService;

	@RequestMapping(value ="/home",method=RequestMethod.GET)
	public ModelAndView getCategory(HttpServletResponse response, KartBean kartBean) throws SQLException {
		List<KartBean> kartBean1;
		ModelAndView model = new ModelAndView("home");
		 kartBean1 = kartService.getcategory(kartBean);
		model.addObject("main",  kartBean1);
		return model;
	}

	@RequestMapping(value = "subCat/{id}", method = RequestMethod.GET)
	public ModelAndView getSubCategory(HttpServletResponse response, @PathVariable String id) throws SQLException {
		List<KartBean> kartBean;
		ModelAndView model = new ModelAndView();
		kartBean= kartService.getSubCategory(id);
		if (kartBean != null) {
			model.setViewName("subCat");
			model.addObject("sub", kartBean);
			
		} else {
			model.addObject("home");
			System.out.println("Try again");
		}
		return model;
	}

	@RequestMapping(value = "brand/{id}", method = RequestMethod.GET)
	public ModelAndView getitems(HttpServletResponse response, @PathVariable String id) throws SQLException {
		List<KartBean> kartBean = kartService.getbrand(id);
		ModelAndView model = new ModelAndView("brand");
		model.addObject("brand", kartBean);
		
		return model;
		
	}
}
