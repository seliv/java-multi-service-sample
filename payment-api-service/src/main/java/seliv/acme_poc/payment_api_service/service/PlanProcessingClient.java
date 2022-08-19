package seliv.acme_poc.payment_api_service.service;

import seliv.acme_poc.payment_api_service.dto.PaymentRequest;
import seliv.acme_poc.payment_api_service.dto.PaymentResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "plan-processing-client", url = "${acme.plan-service-api}")
interface PlanProcessingClient {
    @RequestMapping(method = RequestMethod.GET, path = "plans")
    String getPlans();

    @RequestMapping(method = RequestMethod.POST, path = "api/payment")
    PaymentResponse postPaymentRequest(PaymentRequest paymentRequest);
}
