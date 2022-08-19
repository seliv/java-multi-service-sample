package seliv.acme_poc.process_service.rest;

import seliv.acme_poc.process_service.dto.ProcessingRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/process")
@Slf4j
public class ProcessingController {

    @PostMapping
    public void postProcessingRequest(@RequestBody ProcessingRequest processingRequest) {
        log.info("Processing request accepted: " + processingRequest);
    }
}
