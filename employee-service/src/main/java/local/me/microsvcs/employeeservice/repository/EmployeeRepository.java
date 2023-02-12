package local.me.microsvcs.employeeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import local.me.microsvcs.employeeservice.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    
}
