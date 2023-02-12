package local.me.microsvcs.employeeservice.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import local.me.microsvcs.employeeservice.entity.Department;

@FeignClient(name = "DEPARTMENT-SERVICE")
public interface DepartmentClient {
    @GetMapping("/api/departments/{code}")
    Department getByCode(@PathVariable("code") String code);
}
