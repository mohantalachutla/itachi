package com.itachi.ekart.order.model;

import org.springframework.stereotype.Component;

@Component
public class PaymentDetail {
	
	private int paymentId;
	private int paymentAmount;
	private String paymentMethod;
	private String paymentRef;
	private String paymentDate;
	public PaymentDetail() {
		super();
	}
	public PaymentDetail(int paymentId, int paymentAmount, String paymentMethod, String paymentRef,
			String paymentDate) {
		super();
		this.paymentId = paymentId;
		this.paymentAmount = paymentAmount;
		this.paymentMethod = paymentMethod;
		this.paymentRef = paymentRef;
		this.paymentDate = paymentDate;
	}
	public int getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
	public int getPaymentAmount() {
		return paymentAmount;
	}
	public void setPaymentAmount(int paymentAmount) {
		this.paymentAmount = paymentAmount;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public String getPaymentRef() {
		return paymentRef;
	}
	public void setPaymentRef(String paymentRef) {
		this.paymentRef = paymentRef;
	}
	public String getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}
	@Override
	public String toString() {
		return "PaymentDetail [paymentId=" + paymentId + ", paymentAmount=" + paymentAmount + ", paymentMethod="
				+ paymentMethod + ", paymentRef=" + paymentRef + ", paymentDate=" + paymentDate + "]";
	}
	
}
