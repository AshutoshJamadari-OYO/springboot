package com.example.demoCrud.model.entity;
import java.io.Serializable;
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

    @Column(name = "pin")
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
}
