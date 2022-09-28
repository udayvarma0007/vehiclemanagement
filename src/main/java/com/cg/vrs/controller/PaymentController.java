package com.cg.vrs.controller;


import com.cg.vrs.entity.Customer;

import com.cg.vrs.entity.Payment;
import com.cg.vrs.exception.RecordNotFoundException;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.vrs.entity.Booking;
import com.cg.vrs.entity.Customer;
import com.cg.vrs.entity.Vehicle;
import com.cg.vrs.exception.RecordNotFoundException;

import com.cg.vrs.service.IPaymentService;


@RestController
@RequestMapping("/vrs-payment")
public class PaymentController {
	
	@Autowired
	IPaymentService iPaymentService;
	
	@PostMapping("/addpayment")
	public String addPayment(@Valid@RequestBody Payment payment) throws RecordNotFoundException{
		return iPaymentService.addPayment(payment);
	}
	
	@DeleteMapping("/cancelpayment")
	public String cancelPayment(@RequestBody Payment p) throws RecordNotFoundException{
		return iPaymentService.cancelPayment(p);
	}
	
	@GetMapping("/getpayment/{id}")
	public Payment viewPayment(@PathVariable("id") int p) throws RecordNotFoundException{
		return iPaymentService.viewPayment(p);
	}
	
	@GetMapping("/getallpaymentbyvehicle")
	public List<Payment> viewAllPayments(@RequestBody Vehicle vehicle) throws RecordNotFoundException{
		return iPaymentService.viewAllPayments(vehicle);
	}
	
	@GetMapping("/getpaymentrevenue/{d1}/{d2}")
	public double calculateMonthlyRevenue(@RequestParam("localDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate d1,
			@RequestParam("localDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate d2) throws RecordNotFoundException{
		return iPaymentService.calculateMonthlyRevenue(d1, d2);
	}
	
	@GetMapping("/getpaymentrevenuebyvehicle")
	public double calculateTotalPayment(@RequestBody Vehicle v) throws RecordNotFoundException{
		return iPaymentService.calculateTotalPayment(v);
	}

}
