package com.HMS.hospital_mgmt.dto;

import lombok.Data;

@Data
public class DepartmentDto {
    private String name;
    private int id;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }
}
