package seliv.acme_poc.plan_service.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ProcessingRequest {
    private String targetCode;
    private double amount;
}
