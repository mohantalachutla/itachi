package com.itachi.account.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*@Data
@NoArgsConstructor
@AllArgsConstructor *//* lombok generate automatics getters,setters, constructors which is not working properly*/

@Entity
@Table(name="CUSTOMER_TBL")
public class Customer implements User {
	
	public Customer() {
		super();
	}

	public Customer(int id, String firstname, String lastname, String mail, String password) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.mail = mail;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Id
	private int id;
	private String firstname;
	private String lastname;
	private String mail;
	private String password;
	
	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", mail=" + mail
				+ ", password=" + password + "]";
	}
}
