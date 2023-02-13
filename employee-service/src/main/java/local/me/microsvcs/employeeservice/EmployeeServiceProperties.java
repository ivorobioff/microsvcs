package local.me.microsvcs.employeeservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

import lombok.Getter;

@Getter
@Component
@RefreshScope
public class EmployeeServiceProperties {
    @Value("${local.me.microsvcs.employeeservice.zone:}")
    private String zone;
}
