package com.example.adminka3.DataBases.PostgreSQL.Repository;

import com.example.adminka3.DataBases.PostgreSQL.Models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
}
