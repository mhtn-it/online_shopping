package com.shopping.controller.admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shopping.dao.OrderDAO;

@Controller
@RequestMapping(value = "/admin")
public class HomeAdminController {

	@Autowired
	private OrderDAO orderDAO;

	@GetMapping(value = "/home")
	public String home(HttpServletRequest request) {
		request.setAttribute("orders", orderDAO.findAll(0, 5));
		return "admin/home";
	}

}
