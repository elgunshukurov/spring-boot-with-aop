package az.ms10.springaoptutorial.service.impl;

import az.ms10.springaoptutorial.controller.Executable;
import az.ms10.springaoptutorial.dto.Dto;
import az.ms10.springaoptutorial.service.DtoService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;


@Slf4j
@Component
@RequiredArgsConstructor
public class DtoImpl implements DtoService, ApplicationContextAware, BeanNameAware {
    private final Dto dto;
    private ApplicationContext applicationContext;
    private String beanName;

    @Executable
    @SneakyThrows
    @Override
    public Dto getMessage() {
        return ((DtoImpl)applicationContext.getBean(beanName)).getMessage0();
    }

    @Executable
    @SneakyThrows
    public Dto getMessage0() {
        Thread.sleep(1000);
        dto.setString("Greetings from Spring Boot!");
        log.info("from impl");
        return dto;
    }

    @Override
    public void setBeanName(String name) {
        this.beanName = name;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
