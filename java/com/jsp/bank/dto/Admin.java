package com.jsp.bank.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Admin {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
    private String name;
    private String email;
    private String password;
    
    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
    private List<BankManager> bankmanger;
    
	public List<BankManager> getBankmanger() {
		return bankmanger;
	}
	public void setBankmanger(List<BankManager> bankmanger) {
		this.bankmanger = bankmanger;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
    
	
}