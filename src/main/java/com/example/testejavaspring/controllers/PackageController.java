package com.example.testejavaspring.controllers;

import com.example.testejavaspring.domain.Package;
import com.example.testejavaspring.repositories.PackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/packages")
public class PackageController {
    @Autowired
    PackageRepository packageRepository;

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Package> getAll() {
        return packageRepository.findAll();
    }

    @GetMapping(value = "/{packageId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Package getPackage(@PathVariable UUID packageId) {
        return packageRepository.getById(packageId);
    }
}
