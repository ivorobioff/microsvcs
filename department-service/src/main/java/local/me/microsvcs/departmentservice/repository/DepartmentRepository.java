package local.me.microsvcs.departmentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import local.me.microsvcs.departmentservice.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    public Department findByCode(String code);
}
