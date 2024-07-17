package com.github.juli220620.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CompanyDto {

    private long id;
    private String name;
    private double capitalisation;
    private String industry;
    private List<EmployeeDto> employees;
}
