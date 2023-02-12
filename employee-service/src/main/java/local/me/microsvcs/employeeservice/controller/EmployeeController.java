package local.me.microsvcs.employeeservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import eu.techmoodivns.support.validation.InvalidPayloadException;
import eu.techmoodivns.support.validation.ResourceNotFoundException;
import jakarta.validation.Valid;
import local.me.microsvcs.employeeservice.entity.Employee;
import local.me.microsvcs.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    @PostMapping
    public Employee postMethodName(@RequestBody @Valid Employee data, BindingResult result) {
        if (result.hasErrors()) {
            throw new InvalidPayloadException(result);
        }

        return employeeService.create(data);
    }
    
    @GetMapping("/{id}")
    public Employee getById(@PathVariable Long id) {
        var employee = employeeService.get(id);

        if (employee == null) {
            throw new ResourceNotFoundException("Employee not found!");
        }

        return employee;
    }
}
