package com.itachi.ekart.order.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderRequestHandler implements RequestHandler{
	@Autowired
	private OrderDetails orderDetails;
	@Autowired
	private PaymentDetail paymentDetails;
	public OrderRequestHandler() {
		super();
	}
	public OrderRequestHandler(OrderDetails orderDetails, PaymentDetail paymentDetails) {
		super();
		this.orderDetails = orderDetails;
		this.paymentDetails = paymentDetails;
	}
	public OrderDetails getOrderDetails() {
		return orderDetails;
	}
	public void setOrderDetails(OrderDetails orderDetails) {
		this.orderDetails = orderDetails;
	}
	public PaymentDetail getPaymentDetails() {
		return paymentDetails;
	}
	public void setPaymentDetails(PaymentDetail paymentDetails) {
		this.paymentDetails = paymentDetails;
	}
	@Override
	public String toString() {
		return "OrderRequestHandler [orderDetails=" + orderDetails + ", paymentDetails=" + paymentDetails + "]";
	}
	
}
