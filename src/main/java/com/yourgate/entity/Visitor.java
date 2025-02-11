package com.yourgate.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name="visitors")
public class Visitor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name= "v_name")
	private String name;
	
	@Column(name="v_reason")
	private String reason;
	
	@Column(name = "v_phone")
	private Long phone;
	
	@Column(name = "is_checked_in", columnDefinition = "DATETIME",  updatable = false)
	private LocalDateTime isCheckedIn;

	
//	private LocalDateTime isCheckedIn = LocalDateTime.now();
	
	@Column(name = "v_checkout")
	public String checkout;
	
	public String getCheckout() {
		return checkout;
	}

	public void setCheckout(String checkout) {
		this.checkout = checkout;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	
		public Visitor() {
		
	}
		
		 @PrePersist
		    protected void onCreate() {
		        isCheckedIn = LocalDateTime.now();
		    }
	
	
}
