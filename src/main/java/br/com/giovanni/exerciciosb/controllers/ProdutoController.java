package br.com.giovanni.exerciciosb.controllers;

import br.com.giovanni.exerciciosb.model.entities.Produto;
import br.com.giovanni.exerciciosb.model.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired/*automaticamente ele coloca um objeto adicionado no repositorio pelo spring*/
    private ProdutoRepository produtoRepository;

//    /*podemos deixar toda as especificações dos dados a cargo do postman atravez do Spring boot
//    * assim automatizando mais o projeto*/
//
//    @PostMapping                            /*So aceita produtos com a validacao(ativa a validacao criada)*/
//    public @ResponseBody Produto novoProduto(@Valid Produto produto) {
//        produtoRepository.save(produto);
//        return produto;
//    }

    //    @PostMapping
    @RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
    public @ResponseBody
    Produto salvarProduto(@Valid Produto produto) {
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

    @GetMapping
    public Iterable<Produto> obterProdutos() {
        return produtoRepository.findAll();
    }/*http://localhost:8080/api/produtos*/

    @GetMapping(path = "/nome/{parteNome}")
    public Iterable<Produto> obterProdutosPorNome(@PathVariable String parteNome) {
//        return produtoRepository.findByNomeContainingIgnoreCase(parteNome);
        return produtoRepository.searchByNameLike(parteNome);
    }/*http://localhost:8080/api/produtos/nome/bic*/

//    @GetMapping(path = "/pagina/{numeroPagina}")
//    public Iterable<Produto> obterProdutosPorPagina(
//            @PathVariable int numeroPagina) {
//        Pageable page = PageRequest.of(numeroPagina, 3);
//        return produtoRepository.findAll(page);
//    }/*http://localhost:8080/api/produtos/pagina/0*/

//    @GetMapping(path = "/pagina/{numeroPagina}/{quantidadeDePagina}")
//    public Iterable<Produto> obterProdutosPorPagina(
//            @PathVariable int numeroPagina){
//        Pageable page = PageRequest.of(numeroPagina, 3);
//        return produtoRepository.findAll(page);
//    }/*http://localhost:8080/api/produtos/pagina/0*/

    @GetMapping(path = "/pagina/{numeroPagina}/{quantidadeDePagina}")
    public Iterable<Produto> obterProdutosPorPagina(
            @PathVariable int numeroPagina, @PathVariable int quantidadeDePagina) {
        if (quantidadeDePagina >= 5) quantidadeDePagina = 5;
        Pageable page = PageRequest.of(numeroPagina, quantidadeDePagina);
        return produtoRepository.findAll(page);
    }/*http://localhost:8080/api/produtos/pagina/0/5*/



    @GetMapping(path = "/{id}")
    public Optional<Produto> obterProdutoPorId(@PathVariable int id) {
        return produtoRepository.findById(id);
    }/*http://localhost:8080/api/produtos/1*/


    @DeleteMapping(path = "/{id}")
    public void excluirProduto(@PathVariable int id){
        produtoRepository.deleteById(id);
    }

// como colocamos o salvarProduto para fazer as duas funcoes quando chamado deixaremos comentado aki
//    @PutMapping/*faz tantto alteracao parcial como completo*/
//    public Produto alteraProduto(@Valid Produto produto) {
//        produtoRepository.save(produto);
//        return produto;
//    }
}
