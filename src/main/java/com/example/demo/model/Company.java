package com.example.demo.model;

import java.io.Serializable;
//import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import lombok.*;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "company")
public class Company implements Serializable{

	private static final long serialVersionUID = 4L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "company_id")
	private int companyId;
	
	@Column(name = "company_name")
	private String name;
	
	@Column(name = "contact")
	private String contact;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "street")
	private String street;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "state")
	private String state;
	
	@Column(name = "pincode")
	private String pinCode;

	
    @OneToMany(mappedBy = "company")
    @Fetch(FetchMode.JOIN)
    private List<Department> departmentList;


	@Override
	public String toString() {
		return "Company [companyId=" + companyId + ", name=" + name + ", contact=" + contact + ", status=" + status
				+ ", email=" + email + ", street=" + street + ", city=" + city + ", state=" + state + ", pinCode="
				+ pinCode + ", departmentList=" + departmentList + "]";
	}

    
//	public void setId(int id2) {
//		// TODO Auto-generated method stub
//		this.Id=id2;
//	}
	
//	public Company() {
//
//	}
//
//	public Company(String id, String name, String contact, String status, String email, String street, String city,
//			String state, String pinCode) {
//		super();
//		this.Id = id;
//		this.Name = name;
//		this.Contact = contact;
//		this.Status = status;
//		this.Email = email;
//		this.Street = street;
//		this.City = city;
//		this.State = state;
//		this.PinCode = pinCode;
//	}
//
//	public String getId() {
//		return Id;
//	}
//
//	public void setId(String id) {
//		this.Id = id;
//	}
//
//	public String getName() {
//		return Name;
//	}
//
//	public void setName(String name) {
//		this.Name = name;
//	}
//
//	public String getContact() {
//		return Contact;
//	}
//
//	public void setContact(String contact) {
//		this.Contact = contact;
//	}
//
//	public String getStatus() {
//		return Status;
//	}
//
//	public void setStatus(String status) {
//		this.Status = status;
//	}
//
//	public String getEmail() {
//		return Email;
//	}
//
//	public void setEmail(String email) {
//		this.Email = email;
//	}
//
//	public String getStreet() {
//		return Street;
//	}
//
//	public void setStreet(String street) {
//		this.Street = street;
//	}
//
//	public String getCity() {
//		return City;
//	}
//
//	public void setCity(String city) {
//		this.City = city;
//	}
//
//	public String getState() {
//		return State;
//	}
//
//	public void setState(String state) {
//		this.State = state;
//	}
//
//	public String getPinCode() {
//		return PinCode;
//	}
//
//	public void setPinCode(String pinCode) {
//		this.PinCode = pinCode;
//	}

}
