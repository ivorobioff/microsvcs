package local.me.microsvcs.departmentservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import eu.techmoodivns.support.validation.InvalidPayloadException;
import eu.techmoodivns.support.validation.ResourceNotFoundException;
import jakarta.validation.Valid;
import local.me.microsvcs.departmentservice.entity.Department;
import local.me.microsvcs.departmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/api/departments")
@AllArgsConstructor
public class DepartmentController {

    private DepartmentService departmentService;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Department create(@RequestBody @Valid Department data, BindingResult result) {
        
        if (result.hasErrors()) {
            throw new InvalidPayloadException(result);
        }

        return departmentService.create(data);
    }
    
    @GetMapping("/{code}")
    @ResponseStatus(code = HttpStatus.OK)
    public Department getByCode(@PathVariable String code) {
        var department = departmentService.getByCode(code);

        if (department == null) {
            throw new ResourceNotFoundException("Department not found!");
        }

        return department;
    }
    
}
