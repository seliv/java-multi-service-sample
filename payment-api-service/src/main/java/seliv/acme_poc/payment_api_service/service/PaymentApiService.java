package seliv.acme_poc.payment_api_service.service;

import seliv.acme_poc.payment_api_service.dto.PaymentRequest;
import seliv.acme_poc.payment_api_service.dto.PaymentResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PaymentApiService {
    private final PlanProcessingClient planProcessingClient;

    public PaymentApiService(PlanProcessingClient planProcessingClient) {
        this.planProcessingClient = planProcessingClient;
    }

    public String getPlanList() {
        String result = planProcessingClient.getPlans();
        log.info("PaymentApiService.getPlanList: " + result);
        return result;
    }

    public PaymentResponse processPayment(PaymentRequest paymentRequest) {
        return planProcessingClient.postPaymentRequest(paymentRequest);
    }
}
