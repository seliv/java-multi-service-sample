package seliv.acme_poc.plan_service.rest;

import seliv.acme_poc.plan_service.dto.PaymentRequest;
import seliv.acme_poc.plan_service.dto.PaymentResponse;
import seliv.acme_poc.plan_service.model.Plan;
import seliv.acme_poc.plan_service.model.PlanLeg;
import seliv.acme_poc.plan_service.repo.PlanRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import seliv.acme_poc.plan_service.service.PlanService;

@RestController
@RequestMapping("api/payment")
public class PaymentController {
    private final PlanService planService;

    public PaymentController(PlanService planService) {
        this.planService = planService;
    }

    @PostMapping
    public PaymentResponse postPaymentRequest(@RequestBody PaymentRequest paymentRequest) {
        return planService.processPayment(paymentRequest);
    }

}
