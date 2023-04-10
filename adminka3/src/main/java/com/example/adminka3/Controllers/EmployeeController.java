package com.example.adminka3.Controllers;

import com.example.adminka3.DataBases.PostgreSQL.DTOs.EmployeeDTO;
import com.example.adminka3.DataBases.PostgreSQL.Models.Employee;
import com.example.adminka3.DataBases.PostgreSQL.Repository.EmployeeRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class EmployeeController {

    @Autowired
    EmployeeRepo employeeRepo;

    @GetMapping("api/allEmployee")
    public List<Employee> findAllEmployee(){
        return employeeRepo.findAll();
    }

    @PostMapping("api/addEmployee")
    public String addProduct(@RequestBody EmployeeDTO employeeDTO){
        Employee newEmployee = new Employee(employeeDTO.getName(), employeeDTO.getLastName(),
                employeeDTO.getPosition());
        try {
            employeeRepo.save(newEmployee);
            return "Работник добавлен";
        } catch (Exception e) {
            return "Произошла ошибка, проверьте данные";
        }
    }

    @DeleteMapping("api/deleteEmployee/{key}")
    public String deletingProduct(@PathVariable Long key){
        Optional<Employee> selectedEmployee = employeeRepo.findById(key);
        if(selectedEmployee.isEmpty())
            return "Такого сотрудника нет, проверьте его идентификатор";
        else{
            employeeRepo.delete(selectedEmployee.get());
            return "Сотрудник был успешно удалён";
        }
    }
}
