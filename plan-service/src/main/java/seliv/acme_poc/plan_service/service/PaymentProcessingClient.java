package seliv.acme_poc.plan_service.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import seliv.acme_poc.plan_service.dto.ProcessingRequest;

@FeignClient(value = "processing-client", url = "${acme.process-service-api}")
interface PaymentProcessingClient {

    @RequestMapping(method = RequestMethod.POST, path = "process")
    void postProcessingRequest(ProcessingRequest processingRequest);

}
