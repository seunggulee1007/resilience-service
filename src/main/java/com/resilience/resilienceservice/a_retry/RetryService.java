package com.resilience.resilienceservice.a_retry;

import com.resilience.resilienceservice.exception.RetryException;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RetryService {

    private static final String SIMPLE_RETRY_CONFIG = "simpleRetryConfig";

    @Retry(name= SIMPLE_RETRY_CONFIG, fallbackMethod = "fallback")
    public String process(String param) {
        return callAnotherServer(param);
    }

    private String fallback(String param, Exception ex ) {
        log.info("fallback! your request is " + param);
        return "Recovered: " + ex.toString();
    }

    private String callAnotherServer(String param) {
        throw new RetryException("retry Exception");
    }
}
