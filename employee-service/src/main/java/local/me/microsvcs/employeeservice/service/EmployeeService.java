package local.me.microsvcs.employeeservice.service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.stereotype.Service;

import local.me.microsvcs.employeeservice.entity.Employee;
import local.me.microsvcs.employeeservice.remote.DepartmentClient;
import local.me.microsvcs.employeeservice.repository.EmployeeRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class EmployeeService {
    private EmployeeRepository employeeRepository;
    private DepartmentClient departmentClient;

    public Employee create(Employee data) {
        data.setCreatedAt(LocalDateTime.now(ZoneOffset.UTC));
        return employeeRepository.save(data);
    }

    public Employee get(Long id) {
        var employee = employeeRepository.findById(id).orElse(null);

        if (employee != null) {
            var department = departmentClient.getByCode(employee.getDepartmentCode());
            employee.setDepartment(department);
        }

        return employee;
    }
}
