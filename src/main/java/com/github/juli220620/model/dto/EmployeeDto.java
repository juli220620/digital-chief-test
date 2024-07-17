package com.github.juli220620.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDto {

    private long id;
    private long companyId;
    private String name;
    private String department;
    private double salary;
}
