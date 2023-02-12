package local.me.microsvcs.employeeservice.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import local.me.microsvcs.employeeservice.entity.Department;

@FeignClient(name = "department", url = "http://localhost:8081/api/departments")
public interface DepartmentClient {
    @GetMapping("/{code}")
    Department getByCode(@PathVariable("code") String code);
}
