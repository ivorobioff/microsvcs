package local.me.microsvcs.departmentservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

import lombok.Getter;

@Getter
@Component
@RefreshScope
public class DepartmentServiceProperties {
    @Value("${local.me.microsvcs.departmentservice.zone:}")
    private String zone;
}
