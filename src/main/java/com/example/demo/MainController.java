package com.example.demo;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	
	@Autowired
	private Environment env;
	
	
	@GetMapping("/")
	public String proyectos(HttpSession session, Model template) throws SQLException {
		return "home";
	}
	
}
