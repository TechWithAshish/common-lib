package com.example.logging_common.Intercepter;


import com.example.logging_common.Filter.CorrelationIdFilter;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

@Component
public class CorrelationIdInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        String correlationId = MDC.get(CorrelationIdFilter.CORRELATION_ID_HEADER);
        if (correlationId != null) {
            requestTemplate.header(CorrelationIdFilter.CORRELATION_ID_HEADER, correlationId);
        }
    }
}
