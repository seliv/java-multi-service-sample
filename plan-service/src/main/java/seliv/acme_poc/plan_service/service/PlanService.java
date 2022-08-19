package seliv.acme_poc.plan_service.service;

import lombok.extern.slf4j.Slf4j;
import seliv.acme_poc.plan_service.dto.PaymentRequest;
import seliv.acme_poc.plan_service.dto.PaymentResponse;
import seliv.acme_poc.plan_service.dto.ProcessingRequest;
import seliv.acme_poc.plan_service.model.Plan;
import seliv.acme_poc.plan_service.model.PlanLeg;
import seliv.acme_poc.plan_service.repo.PlanRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PlanService {
    private final PlanRepository planRepository;
    private final PaymentProcessingClient paymentProcessingClient;

    public PlanService(PlanRepository planRepository, PaymentProcessingClient paymentProcessingClient) {
        this.planRepository = planRepository;
        this.paymentProcessingClient = paymentProcessingClient;
    }

    public List<Plan> getAllPlans() {
        return planRepository.findAll();
    }

    public PaymentResponse processPayment(PaymentRequest paymentRequest) {
        String planCode = paymentRequest.getPlanCode();
        Plan plan = planRepository.findPlanByCode(planCode);
        if (plan == null) {
            return new PaymentResponse()
                    .setStatus("Error")
                    .setErrorMessage("Unknown plan: " + planCode)
                    ;
        }
        double amount = paymentRequest.getAmount();

        log.info("Processing payment request: " + paymentRequest);
        for (PlanLeg leg : plan.getPlanLegs()) {
            double legAmount = amount * (0.01 * leg.getPercent());
            log.info("Leg: " + leg + ", amount = " + legAmount);

            ProcessingRequest request = new ProcessingRequest()
                    .setTargetCode(leg.getPlan().getCode() + ":" + leg.getCode())
                    .setAmount(legAmount);
            paymentProcessingClient.postProcessingRequest(request);
        }
        return new PaymentResponse().setStatus("OK");
    }
}
