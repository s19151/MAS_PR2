package io.github.s19151.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import io.github.s19151.model.projection.ReadOrderClientProductModel;
import io.github.s19151.model.projection.ReadOrderModel;
import io.github.s19151.service.OrderService;

@Controller
@RequestMapping("/orders")
public class OrderController {
	private OrderService service;
	
	public OrderController(OrderService service) {
		this.service = service;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView readAllOrders() {
		List<ReadOrderModel> orderList = service.listAll();
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("ordersListDisplay");
		mv.addObject("ordersList", orderList);
		
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/{id}")
	public ModelAndView readClient(@PathVariable("id") Long id) {
		Optional<ReadOrderClientProductModel> order = service.get(id);
		
		ModelAndView mv = new ModelAndView();
		
		if(!order.isEmpty()) {
			mv.setViewName("orderDisplay");
		
			mv.addObject("order", order.get());
		}
		else {
			mv.setViewName("noOrderDisplay");
			mv.addObject("id", id);
		}
		
		return mv;
	}
}
