package seliv.acme_poc.payment_api_service.dto;

import lombok.Data;

@Data
public class PaymentRequest {
    private String planCode;
    private double amount;
}
