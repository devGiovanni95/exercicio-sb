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

    /*podemos deixar toda as especificações dos dados a cargo do postman atravez do Spring boot
    * assim automatizando mais o projeto*/
    @PostMapping
    public @ResponseBody Produto novoProduto(Produto produto) {
        produtoRepository.save(produto);
        return produto;
    }
//    @PostMapping
//    public @ResponseBody Produto novoProduto(
//            @RequestParam String nome,
//            @RequestParam double preco,
//            @RequestParam double desconto ){
//        Produto produto = new Produto(nome, preco, desconto);
//        produtoRepository.save(produto);
//        return produto;
//    }

}
