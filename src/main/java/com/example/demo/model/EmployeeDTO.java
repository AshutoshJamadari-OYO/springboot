package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.*;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {

    @JsonProperty(value = "employee_id")
    private int employeeId;

    @JsonProperty(value = "employee_name")
    private String name;

    @JsonProperty(value = "email")
    private String email;

    @JsonProperty(value = "designation")
    private String designation;

    @JsonProperty(value = "doj")
    private String doj;

    @JsonProperty(value = "gender")
    private String gender;

    @JsonProperty(value = "contact_number")
    private String contact;

    @JsonProperty(value = "street")
    private String street;

    @JsonProperty(value = "pincode")
    private String pinCode;

    @JsonProperty(value = "city")
    private String city;

    @JsonProperty(value = "state")
    private String state;

    @JsonProperty(value = "status")
    private String status;
    
   @JsonProperty(value="department_id")
    private int departmentId;

}
