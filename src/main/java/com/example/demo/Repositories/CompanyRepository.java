package com.example.demo.Repositories;

import com.example.demo.Entities.GameEntities.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long>
{

}
