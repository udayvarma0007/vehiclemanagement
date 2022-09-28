package com.cg.vrs.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;


/*
 
   {
   
 	"bookingDate" : "2022-02-12",
 	"bookedTillDate" : "2022-03-19",
 	"bookingDescription" : "This is first booking",
 	"totalCost" : 2000,
 	"distance" : 40
 	 
   }
 
  
 */

@Entity
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookingId;
	
	@ManyToOne(fetch = FetchType.LAZY )
	@JoinColumn(name = "customer_id", referencedColumnName = "customerId")
	private Customer customer;
	
	@ManyToOne(fetch = FetchType.LAZY )
	@JoinColumn(name = "vehicle_id", referencedColumnName = "vehicleId")
	private Vehicle vehicle;
	
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd") 
	private LocalDate bookingDate;
	
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate bookedTillDate;
	
	private String bookingDescription;
	private double totalCost;
	private double distance;
	
	public Booking() {
		super();
	}

	public Booking(int bookingId, Customer customer, Vehicle vehicle, LocalDate bookingDate, LocalDate bookedTillDate,
			String bookingDescription, double totalCost, double distance) {
		super();
		this.bookingId = bookingId;
		this.customer = customer;
		this.vehicle = vehicle;
		this.bookingDate = bookingDate;
		this.bookedTillDate = bookedTillDate;
		this.bookingDescription = bookingDescription;
		this.totalCost = totalCost;
		this.distance = distance;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public LocalDate getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}

	public LocalDate getBookedTillDate() {
		return bookedTillDate;
	}

	public void setBookedTillDate(LocalDate bookedTillDate) {
		this.bookedTillDate = bookedTillDate;
	}

	public String getBookingDescription() {
		return bookingDescription;
	}

	public void setBookingDescription(String bookingDescription) {
		this.bookingDescription = bookingDescription;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}
	

}


/*
 
  
  
 Layered Arch
 
 Entity - DTO
 
 Repository - DAO
 
 Service - Business Logic
 
 Controller - End Point
  
  
  

  Browser - Chrome
  
  LocalDate - > Java => JSON Object
  
  JSON - Javascript object Notation
  XML 
  
  
cross Join

Table 1 = 4
Table 2 = 4

4x4 = 16
  
 
 */






