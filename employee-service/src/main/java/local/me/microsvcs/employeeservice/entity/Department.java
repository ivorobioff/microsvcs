package local.me.microsvcs.employeeservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    private String name;
    private String description;
    private String code;
    private String zone;
}
