package local.me.microsvcs.departmentservice.service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.stereotype.Service;

import local.me.microsvcs.departmentservice.entity.Department;
import local.me.microsvcs.departmentservice.repository.DepartmentRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DepartmentService {
    private DepartmentRepository departmentRepository;

    public Department create(Department data) {
        data.setCreatedAt(LocalDateTime.now(ZoneOffset.UTC));
        return departmentRepository.save(data);
    }

    public Department getByCode(String code) {
        return departmentRepository.findByCode(code);
    }
}
