package com.example.logging_common.Intercepter;

import com.example.logging_common.Filter.CorrelationIdFilter;
import org.slf4j.MDC;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class RestTemplateInterceptor implements ClientHttpRequestInterceptor {
    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        String correlationId = MDC.get(CorrelationIdFilter.CORRELATION_ID_HEADER);
        if (correlationId != null) {
            request.getHeaders().add(CorrelationIdFilter.CORRELATION_ID_HEADER, correlationId);
        }
        return execution.execute(request, body);
    }
}
