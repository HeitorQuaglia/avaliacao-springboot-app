package com.example.testejavaspring.controllers;

import com.example.testejavaspring.domain.Package;
import com.example.testejavaspring.repositories.PackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/packages")
public class PackageController {
    @Autowired
    PackageRepository packageRepository;

    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public Object searchPackage(@RequestParam String q) {
        if (q.startsWith("$")) {
            return packageRepository.findPackageByCode(q);
        } else {
            return packageRepository.findAllPackagesByCpf(q);
        }
    }
}
