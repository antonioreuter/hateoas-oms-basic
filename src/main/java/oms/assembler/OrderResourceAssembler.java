package oms.assembler;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import oms.controller.CustomerController;
import oms.controller.ItemController;
import oms.controller.OrderController;
import oms.controller.PaymentController;
import oms.model.Order;
import oms.resource.OrderResource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

@Component
public class OrderResourceAssembler extends ResourceAssemblerSupport<Order, OrderResource> {
	
	@Autowired
	private ItemResourceAssembler itemRessourceAssembler;

	public OrderResourceAssembler() {
		super(OrderController.class, OrderResource.class);
	}

	@Override
	public OrderResource toResource(Order order) {
		OrderResource orderResource = createResourceWithId(order.getId(), order);
		orderResource.copyAttributesFrom(order);

		if (!order.isCanceled()) {
			orderResource.add(linkTo(methodOn(OrderController.class).cancel(order.getId())).withRel("Order Cancelation"));
		}

		Link customerLink = linkTo(CustomerController.class).slash("order").slash(order.getId()).withRel("Customer Detail");
		orderResource.add(customerLink);
		
		orderResource.add(linkTo(methodOn(PaymentController.class).paymentsByOrder(order.getId())).withRel("Payment Details"));
		orderResource.add(linkTo(methodOn(ItemController.class).itemsByOrder(order.getId())).withRel("Items"));
		

		
		return orderResource;
	}
}
