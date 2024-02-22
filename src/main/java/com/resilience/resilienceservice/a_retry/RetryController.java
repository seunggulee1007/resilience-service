package com.resilience.resilienceservice.a_retry;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RetryController {

    private final RetryService retryService;

    @GetMapping("/api-call")
    public String apiCall(String param) {
        return retryService.process(param);
    }
}
