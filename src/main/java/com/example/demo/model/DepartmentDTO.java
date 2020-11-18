package com.example.demo.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDTO {

    @JsonProperty(value="department_id")
	private int departmentId;

    @JsonProperty(value="department_name")
	private String name;

    @JsonProperty(value="contact")
	private String contact;

    @JsonProperty(value="status")
	private String status;

    @JsonProperty(value="email")
	private String email;

    @JsonProperty(value="street")
	private String street;

    @JsonProperty(value="city")
	private String city;

    @JsonProperty(value="state")
	private String state;

    @JsonProperty(value="pincode")
	private String pinCode;

    @JsonProperty(value = "company_id")
    private int companyId;

}
