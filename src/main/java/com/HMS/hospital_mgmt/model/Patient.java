package com.HMS.hospital_mgmt.model;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="patients")
public class Patient {

   @Id
   @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private int age;
    private String first_name;
    private String last_name;
    private String address;
    private String sex;
    private String mobile;

}
