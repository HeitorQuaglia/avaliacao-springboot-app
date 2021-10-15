package com.example.testejavaspring.repositories;

import com.example.testejavaspring.domain.Package;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PackageRepository extends JpaRepository<Package, UUID> {
    Package findPackageByCode(String code);

    List<Package> findAllPackagesByCpf(String cpf);
}
