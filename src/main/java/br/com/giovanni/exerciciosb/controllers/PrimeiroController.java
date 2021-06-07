package br.com.giovanni.exerciciosb.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
public class PrimeiroController {

//    @RequestMapping(method = RequestMethod.GET, path = "/ola")   ---1 modo de mapear a pagina web
//    @GetMapping(path = "/ola")    ----  2 modo
//    @GetMapping(path = {"/ola", "saudacao"})
    @GetMapping(path ="/ola")
    public String ola(){
        return "Olá Spring Boot!";
    }
//
//    @PostMapping(path ="saudacao")
//    public String saudacao(){
//        return "Olá Spring Boot!";
//    }
}
