package com.HMS.hospital_mgmt.dto;

import com.HMS.hospital_mgmt.model.Department;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
public class DoctorDto {


    private int id;
    private String name;
    private String last_name;
    private String mobile;
    private DepartmentDto department;

    @Override
    public String toString() {
        return "DoctorDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", mobile='" + mobile + '\'' +
                ", department=" + department +
                '}';
    }
}
