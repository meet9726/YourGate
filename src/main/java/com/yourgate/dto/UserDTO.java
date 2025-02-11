package com.yourgate.dto;

public class UserDTO {

	private String name;
    private String email;
    private String password;
    private Long roleId; // Pass the role ID here
    private String flatNo;
	private String block;
    private Long society;
    private Boolean status = true;
    private String phone;
    private String complain;
    
	 public String getComplain() {
		return complain;
	}
	public void setComplain(String complain) {
		this.complain = complain;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
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
		public Long getSociety() {
			return society;
		}
		public void setSociety(Long society) {
			this.society = society;
		}
		public Boolean getStatus() {
			return status;
		}
		public void setStatus(Boolean status) {
			this.status = status;
		}
		
		public void setPhone(String phone) {
			this.phone = phone;
		}
		
		public String getPhone() {
			return phone;
		}
	
}
