package local.me.microsvcs.employeeservice.remote;

import org.springframework.stereotype.Component;

import local.me.microsvcs.employeeservice.entity.Department;

@Component
public class DepartmentClientFallback implements DepartmentClient {

    @Override
    public Department getByCode(String code) {
        return Department.builder()
                .code("IT000")
                .description("Default")
                .zone("*")
                .name("default")
                .build();
    }

}
