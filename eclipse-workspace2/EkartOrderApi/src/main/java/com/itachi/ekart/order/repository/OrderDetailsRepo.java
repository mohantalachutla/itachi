/**
 * 
 */
package com.itachi.ekart.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itachi.ekart.order.model.OrderDetails;

/**
 * @author itachi
 *
 */
public interface OrderDetailsRepo extends JpaRepository<OrderDetails, String>{

}
