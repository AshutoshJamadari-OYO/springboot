package com.example.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor

@Table(name="department")
@Entity
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "department_id")
	private int departmentId;

	@Column(name="department_name")
	private String name;

	@Column(name="contact")
	private String contact;
	
	@Column(name="status")
	private String status;
	
	@Column(name="email")
	private String email;
	
	@Column(name="street")
	private String street;
	
	@Column(name="city")
	private String city;
	
	@Column(name="state")
	private String state;
	
	@Column(name="pincode")
	private String pinCode;

    @OneToMany(mappedBy = "department")
    private List<Employee> employeeList;

    @ManyToOne(cascade = CascadeType.MERGE)
    @Fetch(FetchMode.JOIN)
    @JsonIgnore
    @JoinColumn(name="company_id", nullable = false)
    private Company company;

//	public void setId(int id2) {
//		// TODO Auto-generated method stub
//		this.Id=id2;
//	}
	
//	@OneToMany(name="employeeid_fk")
//	private Employee employee;

//	@OneToMany(targetEntity=Employee.class, mappedBy="userRole",cascade=CascadeType.ALL, fetch = FetchType.LAZY)    
//	private List<Employee> user = new ArrayList<>();
	
//	public Department() {
//	}
//	
//	public Department(String id, String name, String contact, String status, String email, String street, String city,
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
//	public void setId(String id) {
//		this.Id = id;
//	}
//	public String getName() {
//		return Name;
//	}
//	public void setName(String name) {
//		this.Name = name;
//	}
//	public String getContact() {
//		return Contact;
//	}
//	public void setContact(String contact) {
//		this.Contact = contact;
//	}
//	public String getStatus() {
//		return Status;
//	}
//	public void setStatus(String status) {
//		this.Status = status;
//	}
//	public String getEmail() {
//		return Email;
//	}
//	public void setEmail(String email) {
//		this.Email = email;
//	}
//	public String getStreet() {
//		return Street;
//	}
//	public void setStreet(String street) {
//		this.Street = street;
//	}
//	public String getCity() {
//		return City;
//	}
//	public void setCity(String city) {
//		this.City = city;
//	}
//	public String getState() {
//		return State;
//	}
//	public void setState(String state) {
//		this.State = state;
//	}
//	public String getPinCode() {
//		return PinCode;
//	}
//	public void setPinCode(String pinCode) {
//		this.PinCode = pinCode;
//	}
	
}
