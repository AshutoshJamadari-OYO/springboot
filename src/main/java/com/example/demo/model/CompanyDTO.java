package com.example.demo.model;

import java.io.Serializable;


import com.fasterxml.jackson.annotation.JsonProperty;

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
public class CompanyDTO implements Serializable{

	
	private static final long serialVersionUID = 4L;

	@JsonProperty(value= "company_id")
	private int companyId;
	
	@JsonProperty(value= "company_name")
	private String name;
	
	@JsonProperty(value= "contact")
	private String contact;
	
	@JsonProperty(value= "status")
	private String status;
	
	@JsonProperty(value= "email")
	private String email;
	
	@JsonProperty(value= "street")
	private String street;
	
	@JsonProperty(value= "city")
	private String city;
	
	@JsonProperty(value= "state")
	private String state;
	
	@JsonProperty(value= "pincode")
	private String pinCode;

	@Override
	public String toString() {
		return "CompanyDTO [companyId=" + companyId + ", name=" + name + ", contact=" + contact + ", status=" + status
				+ ", email=" + email + ", street=" + street + ", city=" + city + ", state=" + state + ", pinCode="
				+ pinCode + "]";
	}


}
