package br.com.giovanni.exerciciosb.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calculadora")
public class CalculadoraController {

    // /calculadora/somar/10/20
    @GetMapping("/somar/{a}/{b}")
    public int somar(@PathVariable int a, @PathVariable int b){
        return a + b;
    }/*http://localhost:8080/calculadora/somar/10/50/*/

    // /calculadora/subtrair?a=100&b=39
    @GetMapping("/subtrair")
    public int subtrair(@RequestParam(name = "a") int a,
                        @RequestParam(name = "b") int b){
        return a - b;
    }/*http://localhost:8080/calculadora/subtrair?a=100&b=39*/
}
