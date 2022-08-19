package seliv.acme_poc.payment_api_service.dto;

import lombok.Data;

@Data
public class PaymentResponse {
    private String status;
    private String errorMessage;
}
