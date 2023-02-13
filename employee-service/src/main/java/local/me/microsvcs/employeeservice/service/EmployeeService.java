package local.me.microsvcs.employeeservice.service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.stereotype.Service;

import local.me.microsvcs.employeeservice.EmployeeServiceProperties;
import local.me.microsvcs.employeeservice.entity.Employee;
import local.me.microsvcs.employeeservice.remote.DepartmentClient;
import local.me.microsvcs.employeeservice.repository.EmployeeRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class EmployeeService {
    private EmployeeRepository employeeRepository;
    private DepartmentClient departmentClient;
    private EmployeeServiceProperties properties;

    public Employee create(Employee data) {
        data.setCreatedAt(LocalDateTime.now(ZoneOffset.UTC));
        var employee = employeeRepository.save(data);
        employee.setZone(properties.getZone());
        return employee;
    }

    public Employee get(Long id) {
        var employee = employeeRepository.findById(id).orElse(null);

        if (employee != null) {
            var department = departmentClient.getByCode(employee.getDepartmentCode());
            employee.setDepartment(department);
        }

        employee.setZone(properties.getZone());

        return employee;
    }
}
