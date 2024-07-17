package com.github.juli220620.controller;

import com.github.juli220620.model.dto.CompanyDto;
import com.github.juli220620.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/company")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService service;

    @PostMapping
    public long addCompany(@RequestBody CompanyDto dto) {
        return service.addCompany(dto);
    }

    @PutMapping
    public void updateCompany(@RequestBody CompanyDto dto) {
        service.updateCompany(dto);
    }

    @GetMapping("/{id}")
    public CompanyDto getCompany(@PathVariable long id) {
        return service.getCompanyById(id).orElseThrow();
    }

    @GetMapping
    public List<CompanyDto> getAllCompanies() {
        return service.getAll();
    }

    @DeleteMapping("/{id}")
    public void deleteCompany(@PathVariable long id) {
        service.deleteCompany(id);
    }

}
