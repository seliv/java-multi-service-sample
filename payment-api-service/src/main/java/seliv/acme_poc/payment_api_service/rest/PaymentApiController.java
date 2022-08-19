package seliv.acme_poc.payment_api_service.rest;

import seliv.acme_poc.payment_api_service.dto.PaymentRequest;
import seliv.acme_poc.payment_api_service.dto.PaymentResponse;
import seliv.acme_poc.payment_api_service.service.PaymentApiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/payment")
@Slf4j
public class PaymentApiController {

    private final PaymentApiService paymentApiService;

    public PaymentApiController(PaymentApiService paymentApiService) {
        this.paymentApiService = paymentApiService;
    }

    @GetMapping
    public String getTest() {
        return "Test: " + paymentApiService.getPlanList();
    }

    @PostMapping
    public PaymentResponse postPaymentRequest(@RequestBody PaymentRequest paymentRequest) {
        log.info("Payment request accepted: " + paymentRequest);
        return paymentApiService.processPayment(paymentRequest);
    }
}
