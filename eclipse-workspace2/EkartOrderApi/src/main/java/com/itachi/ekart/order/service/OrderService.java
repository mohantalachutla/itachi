package com.itachi.ekart.order.service;

import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.itachi.ekart.order.model.OrderDetails;
import com.itachi.ekart.order.model.OrderRequestHandler;
import com.itachi.ekart.order.model.PaymentDetail;
import com.itachi.ekart.order.repository.OrderDetailsRepo;

@Service
public class OrderService {
	@Autowired
	OrderDetailsRepo repo;
	@Autowired
	@Lazy	//creates only when invoked
	RestTemplate restTemplate;
	@Autowired
	HttpHeaders httpHeaders;

	Map<String, Object> mResponse;
	List<OrderRequestHandler> lResopnse;
	ResponseEntity<PaymentDetail> resEnt4pd;
	RequestEntity<PaymentDetail> reqEnt4pd;
	OrderDetails od;
	PaymentDetail pd;

	public Map<String, Object> bookOrder(OrderRequestHandler rh) throws Exception {
		od = rh.getOrderDetails();
		pd = rh.getPaymentDetails();
		// resEnt4pd =& restTemplate.postForEntity("http://locahost:5004/payment/", pd,
		// PaymentDetail.class);

		/*
		 * ResponseEntity,RequestEntity =& HttpEntity, HttpStatus, HttpMethod HttpEntity
		 * =& HttpHeader, body HttpHeader=& MultiValueMap
		 */

		// generating http headers
		httpHeaders.set("ACCEPT", "application/json");

		// generating httpEntity
		HttpEntity<PaymentDetail> httpEntity4PD = new HttpEntity<PaymentDetail>(pd, httpHeaders); // can be used with
																									// setters

		// generating requestEntity
		reqEnt4pd = new RequestEntity<PaymentDetail>(pd, httpHeaders, HttpMethod.POST, new URI("http://localhost:5007/payment/"));
		
		// generation RequestEntity
		restTemplate.exchange(reqEnt4pd, PaymentDetail.class);

		pd = resEnt4pd.getBody();
		if (pd.getPaymentId() != 0) {
			od = repo.save(od);
			mResponse.put("oderDetails", od);
			mResponse.put("paymentDetails", pd);
		}
		return mResponse;
	}

	public List<OrderDetails> getAllOrderDetails() throws Exception {

		return repo.findAll();
	}

	public Optional<OrderDetails> getOrderDetailsById(String id) throws Exception {

		return repo.findById(id);
	}

	public void deleteOrderDetailsById(String id) throws Exception {

		repo.deleteById(id);
	}

	public void deleteAllOrderDetails() throws Exception {

		repo.deleteAll();
	}
}
