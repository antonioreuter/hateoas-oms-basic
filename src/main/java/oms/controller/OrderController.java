package oms.controller;

import java.util.List;

import oms.model.Order;
import oms.model.OrderResource;
import oms.model.OrderResourceAssembler;
import oms.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
	
	@Autowired
	private OrderService orderService;

	@Autowired
	private OrderResourceAssembler orderResourceAssembler;

    @RequestMapping(method= RequestMethod.GET)
    public List<OrderResource> getOrders() {
    	List<Order> orders = orderService.getAll();
    	return orderResourceAssembler.toResources(orders);
    }

    @RequestMapping("/{orderId}")
    public OrderResource get(@PathVariable Long orderId) {
    	Order order = orderService.get(orderId);
    	return orderResourceAssembler.toResource(order);
    }

    @RequestMapping(method= RequestMethod.POST)
    public Order purchase(Order order) {
    	return orderService.purchase(order); 
    }
    
    @RequestMapping(method= RequestMethod.PUT)
    public Order update(Order order) {
    	return orderService.update(order); 
    }
    
    @RequestMapping(method= RequestMethod.DELETE)
    public void delete(Long orderId) {
    	orderService.delete(orderId);
    }
    
    @RequestMapping(value="/{orderId}/cancel",  method= RequestMethod.PUT)
    public OrderResource cancel(@PathVariable("orderId") Long orderId) {
    	Order canceledOrder = orderService.cancel(orderId);
    	return orderResourceAssembler.toResource(canceledOrder);
    }
}
