package br.com.giovanni.exerciciosb.model.repositories;

import br.com.giovanni.exerciciosb.model.entities.Produto;
import org.springframework.data.repository.CrudRepository;

public interface ProdutoRepository
        extends CrudRepository<Produto, Integer> {



}
