package az.ms10.springaoptutorial.controller;

import az.ms10.springaoptutorial.dto.Dto;
import az.ms10.springaoptutorial.service.DtoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class IndexController {
    private final DtoService service;

    @GetMapping
    public Dto sayHello(){
        System.out.println("from controller");
        return service.getMessage();
    }

}
