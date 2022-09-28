package com.cg.vrs.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.cg.vrs.dao.IPaymentRepository;
import com.cg.vrs.entity.Booking;
import com.cg.vrs.entity.Customer;
import com.cg.vrs.entity.Driver;
import com.cg.vrs.entity.Payment;
import com.cg.vrs.entity.Vehicle;
import com.cg.vrs.exception.RecordNotFoundException;

public class TestIPaymentServiceImpl {
	@Mock
	IPaymentRepository  pr;
	@InjectMocks
	IPaymentServiceImpl ps;
	Payment payment;

	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
		Payment payment=new Payment(1,"online",LocalDate.of(2022, 03, 10) , null, null,null, "complrted");
		}
	@Test
	public void testAddPayment() throws RecordNotFoundException  {
		Mockito.when(pr.save(payment)).thenReturn(payment);
		String expectedResult ="Payment added successfully";
		assertEquals(expectedResult,ps.addPayment(payment));
		Mockito.verify(pr,Mockito.times(1)).save(payment);
	}
	@Test
	public void testViewPaymentFailure() {
		int id=-101;
		Mockito.when(pr.findById(id)).thenReturn(Optional.empty());
		assertThrows( RecordNotFoundException.class,()->ps.viewPayment(id));
		Mockito.verify(pr,Mockito.times(1)).findById(id);
	}
}
