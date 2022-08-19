package seliv.acme_poc.plan_service.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class PaymentResponse {
    private String status;
    private String errorMessage;
}
