package com.HMS.hospital_mgmt.dto;

import lombok.Data;

@Data
public class PatientDto {
    private int id;
    private String first_name;
    private String last_name;
    private int age;
    private String address;
    private String sex;
    private String mobile;

    @Override
    public String toString() {
        return "PatientDto{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", sex='" + sex + '\'' +
                ", mobile='" + mobile + '\'' +
                '}';
    }


}
