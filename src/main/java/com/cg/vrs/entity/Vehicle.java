package com.cg.vrs.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class Vehicle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  int vehicleId;
	
	private String vehicleNumber;
	private String type;//car//bus
	private String category ; //ac or nonac
	private String description;
	private String location;
	private String capacity;
	private double chargesPerKM;
	private double fixedCharges;
	
	@OneToMany(mappedBy = "vehicle" , fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Booking> bookings;
	
	@OneToMany(mappedBy = "vehicle" , fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Payment> payments;
	
	@ManyToMany(mappedBy = "vehicles")
	private List<Driver> drivers;

	public Vehicle() {
		super();
	}

	public Vehicle(int vehicleId, String vehicleNumber, String type, String category, String description,
			String location, String capacity, double chargesPerKM, double fixedCharges, List<Booking> bookings,
			List<Payment> payments, List<Driver> drivers) {
		super();
		this.vehicleId = vehicleId;
		this.vehicleNumber = vehicleNumber;
		this.type = type;
		this.category = category;
		this.description = description;
		this.location = location;
		this.capacity = capacity;
		this.chargesPerKM = chargesPerKM;
		this.fixedCharges = fixedCharges;
		this.bookings = bookings;
		this.payments = payments;
		this.drivers = drivers;
	}

	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	public double getChargesPerKM() {
		return chargesPerKM;
	}

	public void setChargesPerKM(double chargesPerKM) {
		this.chargesPerKM = chargesPerKM;
	}

	public double getFixedCharges() {
		return fixedCharges;
	}

	public void setFixedCharges(double fixedCharges) {
		this.fixedCharges = fixedCharges;
	}

	public List<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

	public List<Driver> getDrivers() {
		return drivers;
	}

	public void setDrivers(List<Driver> drivers) {
		this.drivers = drivers;
	}

	public List<Payment> getPayments() {
		return payments;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}
	
}
