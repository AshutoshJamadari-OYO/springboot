package com.example.demoCrud.model.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="employee")
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Integer employeeId;

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

    @Column(name="pin")
    private String pinCode;

    @Column(name="status")
    private String status;

    @ManyToOne(cascade = CascadeType.MERGE)
    @Fetch(FetchMode.JOIN)
    @JsonIgnore
    @JoinColumn(name="department_id", nullable = false)
    private Department department;

}
