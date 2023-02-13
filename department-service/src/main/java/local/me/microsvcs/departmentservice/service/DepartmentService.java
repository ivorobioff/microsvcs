package local.me.microsvcs.departmentservice.service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.stereotype.Service;

import local.me.microsvcs.departmentservice.DepartmentServiceProperties;
import local.me.microsvcs.departmentservice.entity.Department;
import local.me.microsvcs.departmentservice.repository.DepartmentRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DepartmentService {
    private DepartmentRepository departmentRepository;
    private DepartmentServiceProperties properties;

    public Department create(Department data) {
        data.setCreatedAt(LocalDateTime.now(ZoneOffset.UTC));
        var department = departmentRepository.save(data);

        department.setZone(properties.getZone());

        return department;
    }

    public Department getByCode(String code) {
        var department = departmentRepository.findByCode(code);
        department.setZone(properties.getZone());
        return department;
    }
}
