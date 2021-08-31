package io.github.s19151.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import io.github.s19151.model.Client;
import io.github.s19151.service.ClientService;

@Controller
//@RequestMapping("/clients")
public class ClientController {
	private ClientService service;
	
	public ClientController(ClientService service) {
		this.service = service;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "clients")
	public ModelAndView getAll() {
		List<Client> clientList = service.listAll();
		
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("clientList", clientList);
		
		return mv;
	}
}
