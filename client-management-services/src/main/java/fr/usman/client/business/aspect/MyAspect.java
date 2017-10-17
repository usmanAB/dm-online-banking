package fr.usman.client.business.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.logging.Logger;


/**
 * Created by Usman on 16/10/2017.
 */

@Aspect
@Component
public class MyAspect {

    private static final Logger logger = Logger.getLogger(String.valueOf(MyAspect.class));


    @Before("execution(* fr.usman.client.business.controllers.UserController*.*(..)) && @annotation(requestMapping)")
    public void set_controller_methods_name(JoinPoint joinPoint, RequestMapping requestMapping) {

        logger.info("[UserController METHOD -->"+joinPoint.getSignature().getName()+"}");
        logger.info("[UserController HTTP VERB-->"+requestMapping.name().toString()+requestMapping.method()[0]+"}");
        logger.info("[UserController HTTP PATH-->"+requestMapping.name().toString()+requestMapping.value()[0]+"}");
        logger.info("[UserController HTTP PAram-->"+requestMapping.name().toString()+requestMapping+"}");
    }



    @Around("execution(* fr.usman.client.business.services.ClientService*.*(..))")
    public void logTimeMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        joinPoint.proceed();
        stopWatch.stop();

        logger.info("[TIME -->"+stopWatch.getTotalTimeMillis()+"]");
    }

    @Around("execution(* fr.usman.client.business.controllers.UserController*.*(..))")
    public void logControllerClass(ProceedingJoinPoint joinPoint) throws Throwable {

        joinPoint.proceed();

        logger.info("[Controller Class Name : -->"+joinPoint.getTarget().getClass().getName()+"]");

    }

}
