package br.com.giovanni.exerciciosb.controllers;

import br.com.giovanni.exerciciosb.model.entities.Cliente;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @GetMapping(path = "/qualquer")
    public Cliente obterCliente(){
        return new Cliente(28, "Pedro", "123.456.789-00");
    }


    @GetMapping("/{id}")
    public Cliente obterClientePorId1(@PathVariable int id){
        return new Cliente(id, "Maria","987.654.321-00");
    }

    @GetMapping
    public Cliente obterClientePorId(
            @RequestParam(name = "id", defaultValue = "1")int id){
                return new Cliente(id, "Joao","357.669.541-58");
    }
}
