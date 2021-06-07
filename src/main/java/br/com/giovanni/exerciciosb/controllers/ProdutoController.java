package br.com.giovanni.exerciciosb.controllers;

import br.com.giovanni.exerciciosb.model.entities.Produto;
import br.com.giovanni.exerciciosb.model.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired/*automaticamente ele coloca um objeto adicionado no repositorio pelo spring*/
    private ProdutoRepository produtoRepository;

    @PostMapping
    public @ResponseBody Produto novoProduto(@RequestParam String nome){
        Produto produto = new Produto(nome);
        produtoRepository.save(produto);
        return produto;
    }

}
