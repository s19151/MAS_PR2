package io.github.s19151.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import io.github.s19151.model.projection.ClientType;
import io.github.s19151.model.projection.ReadClientModel;
import io.github.s19151.model.projection.ReadClientOrderModel;
import io.github.s19151.service.ClientService;

@Controller
@RequestMapping("/clients")
public class ClientController {
	private ClientService service;
	
	public ClientController(ClientService service) {
		this.service = service;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView readAllClients() {
		List<ReadClientModel> clientList = service.listAll();
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("clientsListDisplay");
		mv.addObject("clientsList", clientList);
		
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/{id}")
	public ModelAndView readClient(@PathVariable("id") Long id) {
		Optional<ReadClientOrderModel> client = service.get(id);
		
		ModelAndView mv = new ModelAndView();
		
		if(!client.isEmpty()) {
			if(client.get().getClientType() == ClientType.ClientPerson)
				mv.setViewName("clientPersonDisplay");
		
			else
				mv.setViewName("clientCompanyDisplay");
		
			mv.addObject("client", client.get());
		}
		else {
			mv.setViewName("noClientDisplay");
			mv.addObject("id", id);
		}
		
		return mv;
	}
}
