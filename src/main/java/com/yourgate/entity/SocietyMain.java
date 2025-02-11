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
@Table(name= "society_main")
public class SocietyMain {
	
	
	public SocietyMain() {
//		super();
	}


	public SocietyMain(Long id, String firstName, String lastName, String regNumber, LocalDateTime createdDate,
			String password) {
//		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.regNumber = regNumber;
		this.createdDate = createdDate;
		this.password = password;
	}


	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
    @Column(name = "f_name", nullable = false, length = 100)
	private String firstName;
    
    @Column(name = "l_name", nullable = false, length = 100)
	private String lastName;
    
    @Column(name = "reg_number", nullable = false, length = 255)
    private String regNumber;
		
	@Column(name = "created_date", columnDefinition = "DATETIME",updatable= false)
	private LocalDateTime createdDate;
	
	@Column(name = "psw", nullable = false, length = 50)
	private String password;
	
	
	//infuture we neeed to change to get local time
	@PrePersist
    protected void onCreate() {
	 createdDate = LocalDateTime.now();
    }


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public  String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getRegNumber() {
		return regNumber;
	}


	public void setRegNumber(String regNumber) {
		this.regNumber = regNumber;
	}


	public LocalDateTime getCreatedDate() {
		return createdDate;
	}


	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
}
