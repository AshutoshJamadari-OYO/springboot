package com.example.demoCrud.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

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

    @Column(name="pin")
    private String pinCode;

    @OneToMany(mappedBy = "department")
    private List<Employee> employeeList;

    @ManyToOne(cascade = CascadeType.MERGE)
    @Fetch(FetchMode.JOIN)
    @JsonIgnore
    @JoinColumn(name="company_id", nullable = false)
    private Company company;

}
