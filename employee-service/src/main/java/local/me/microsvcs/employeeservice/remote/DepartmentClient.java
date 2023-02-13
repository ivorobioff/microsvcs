package local.me.microsvcs.employeeservice.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import local.me.microsvcs.employeeservice.entity.Department;

@FeignClient(name = "DEPARTMENT-SERVICE", path = "/api/departments", fallback = DepartmentClientFallback.class)
public interface DepartmentClient {
    @GetMapping("/{code}")
    Department getByCode(@PathVariable("code") String code);
}
