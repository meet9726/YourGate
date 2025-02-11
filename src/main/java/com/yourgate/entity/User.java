package com.yourgate.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="name")
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "role_id", referencedColumnName = "id") 
	private Roles role;
	
	@Column(name ="email")
	private String email;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "created_date", columnDefinition = "DATETIME",updatable= false)
	private LocalDateTime createdDate;


	@OneToMany
	@JoinColumn(name = "user_id",referencedColumnName = "id")
	private List<Complaint> complain;
	
	
	 @Column(name = "phone", unique = true, nullable = false)
	    private String phone;

	    @Column(name = "flat_no")
	    private String flatNo;

	    @Column(name = "block")
	    private String block;

	    @ManyToOne
	    @JoinColumn(name = "society_id", referencedColumnName = "id")
	    private Society society;  // ✅ Link user to society

	    @Column(name = "status", columnDefinition = "BOOLEAN DEFAULT true")
	    private Boolean status = true;  // ✅ Active or inactive user


	    @Column(name = "updated_date", columnDefinition = "DATETIME")
	    private LocalDateTime updatedDate;
	


	@PrePersist
	    protected void onCreate() {
		 createdDate = LocalDateTime.now();
	    }

	
	public User() {
		
	}
	

	
	public User(String name, Roles role, String email, String password, String phone, String flatNo, String block, Society society) {
        this.name = name;
        this.role = role;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.flatNo = flatNo;
        this.block = block;
        this.society = society;
        this.status = true;
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

	public Roles getRole() {
		return role;
	}

	public void setRole(Roles role) {
		this.role = role;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	 public List<Complaint> getComplain() {
			return complain;
		}


	public void setComplain(List<Complaint> complain) {
		this.complain = complain;
		}
	
	public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFlatNo() {
        return flatNo;
    }

    public void setFlatNo(String flatNo) {
        this.flatNo = flatNo;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public Society getSociety() {
        return society;
    }

    public void setSociety(Society society) {
        this.society = society;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }

    
}
