package az.ms10.springaoptutorial.aop;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Aspect
public class ExecutionTimeLogger {

    @Pointcut(value = "execution(* az.ms10.springaoptutorial.service.impl.DtoImpl.* (..))")
    private void logExecutionTimePointCut(){
    }

    @Pointcut(value = "@annotation(az.ms10.springaoptutorial.controller.Executable)")
    private void logExecutableAnnotation(){
    }

    @SneakyThrows
    @Around(value = "logExecutableAnnotation()")
    public void logExecutionTime(ProceedingJoinPoint point){
        long before = System.currentTimeMillis();
        point.proceed();
        long after = System.currentTimeMillis();
        log.info("Elapsed time --> {}", after-before);
    }

}
