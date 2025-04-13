package com.example.logging_common.Aop;


import com.example.logging_common.Filter.CorrelationIdFilter;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    public LoggingAspect() {
        System.out.println(">>> LoggingAspect initialized");
    }

    @Pointcut("within(@org.springframework.web.bind.annotation.RestController *) || within(@org.springframework.stereotype.Service *) || within(@org.springframework.stereotype.Repository *)")
    public void loggableMethods() {}

    @Before("loggableMethods()")
    public void logBefore(JoinPoint joinPoint) {
        String correlationId = MDC.get(CorrelationIdFilter.CORRELATION_ID_HEADER);
        logger.info("➡️ [{}] Executing method: {}", correlationId, joinPoint.getSignature());
    }

    @AfterReturning(pointcut = "loggableMethods()")
    public void logAfter(JoinPoint joinPoint) {
        String correlationId = MDC.get(CorrelationIdFilter.CORRELATION_ID_HEADER);
        logger.info("✅ [{}] Completed method: {} → {}", correlationId, joinPoint.getSignature());
    }

    @AfterThrowing(pointcut = "loggableMethods()", throwing = "ex")
    public void logException(JoinPoint joinPoint, Throwable ex) {
        String correlationId = MDC.get(CorrelationIdFilter.CORRELATION_ID_HEADER);
        logger.error("❌ [{}] Exception in method {}: {}", correlationId, joinPoint.getSignature(), ex.getMessage());
    }
}
