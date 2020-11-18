package com.example.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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

@Table(name="employee")
@Entity
public class Employee{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employee_id")
	private int employeeId;
	
	@Column(name="employee_name")
	private String name;
	
	@Column(name="email")
	private String email;
	
	@Column(name="designation")
	private String designation;
	
	@Column(name="doj")
	private String doj;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="contact")
	private String contact;
	
	@Column(name="street")
	private String street;
	
	@Column(name="city")
	private String city;
	
	@Column(name="state")
	private String state;
	
	@Column(name="pincode")
	private String pinCode;
	
	@Column(name="status")
	private String status;

    @ManyToOne(cascade = CascadeType.MERGE)
    @Fetch(FetchMode.JOIN)
    @JsonIgnore
    @JoinColumn(name="department_id", nullable = false)
    private Department department;

    
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "department_id")
//	@ManyToOne
//    private Department department;

	
//	public Employee() {
//		super();
//	}
//	
//	public Employee(String id, String name, String contact, String email, String street, String city, String state,
//			String pinCode, String status, String doj, String designation, String gender, String departmentID) {
//		super();
//		this.Id = id;
//		this.Name = name;
//		this.Contact = contact;
//		this.Email = email;
//		this.Street = street;
//		this.City = city;
//		this.State = state;
//		this.PinCode = pinCode;
//		this.Status = status;
//		this.Doj = doj;
//		this.Designation = designation;
//		this.Gender = gender;
//		this.department= new Department(departmentID ,"","","","","","","","");
//	}
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
//	public String getStatus() {
//		return Status;
//	}
//	public void setStatus(String status) {
//		this.Status = status;
//	}
//	public String getDoj() {
//		return Doj;
//	}
//	public void setDoj(String doj) {
//		this.Doj = doj;
//	}
//	public String getDesignation() {
//		return Designation;
//	}
//	public void setDesignation(String designation) {
//		this.Designation = designation;
//	}
//	public String getGender() {
//		return Gender;
//	}
//	public void setGender(String gender) {
//		this.Gender = gender;
//	}
//
//	public Department getDepartment() {
//		return department;
//	}
//
//	public void setDepartment(Department department) {
//		this.department = department;
//	}
	
}
