/**
 * 
 */
package com.itachi.ekart.order.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.stereotype.Component;

/**
 * @author itachi
 *
 */
@Component
@Entity
@Table
public class OrderDetails {
	@Id
	@Column(name="orderId")
	@GeneratedValue
	private int orderId;
	@NotEmpty
	private String orderDate;
	@NotEmpty
	private int orderAmount;
	@NotEmpty
	private String address;
	private String productId;  //impl: should be mapped to product details table
	private String paymentId;
	public OrderDetails() {
		super();
	}
	
	public OrderDetails(int orderId, String orderDate, int orderAmount, String address, String productId,
			String paymentId) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.orderAmount = orderAmount;
		this.address = address;
		this.productId = productId;
		this.paymentId = paymentId;
	}

	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	
	public int getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(int orderAmount) {
		this.orderAmount = orderAmount;
	}

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}
	@Override
	public String toString() {
		return "OrderDetails [orderId=" + orderId + ", orderDate=" + orderDate + ", address=" + address + ", productId="
				+ productId + ", paymentId=" + paymentId + "]";
	}

	
	
}
