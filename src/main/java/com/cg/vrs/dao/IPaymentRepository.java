package com.cg.vrs.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.vrs.entity.Customer;
import com.cg.vrs.entity.Payment;

@Repository
public interface IPaymentRepository extends JpaRepository<Payment, Integer>{
	
}


