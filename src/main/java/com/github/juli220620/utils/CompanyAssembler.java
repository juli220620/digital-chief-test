package com.github.juli220620.utils;

import com.github.juli220620.model.CompanyEntity;
import com.github.juli220620.model.Industry;
import com.github.juli220620.model.dto.CompanyDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CompanyAssembler {

    private final EmployeeAssembler assembler;

    public CompanyEntity assemble(CompanyDto data) {
        return assemble(new CompanyEntity(), data);
    }


    public CompanyEntity assemble(CompanyEntity entity, CompanyDto data) {
        entity.setId(data.getId());
        entity.setName(data.getName());
        entity.setCapitalisation(data.getCapitalisation());
        entity.setIndustry(Industry.valueOf(data.getIndustry()));
        return entity;
    }

    public CompanyDto disassemble(CompanyEntity entity) {
        var data = new CompanyDto();

        data.setId(entity.getId());
        data.setName(entity.getName());
        data.setIndustry(entity.getIndustry().toString());
        data.setCapitalisation(entity.getCapitalisation());

        data.setEmployees(entity.getEmployees().stream().map(assembler::disassemble).collect(Collectors.toList()));

        return data;
    }
}
