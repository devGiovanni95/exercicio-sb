//package br.com.giovanni.exerciciosb.model.repositories;
//
//import br.com.giovanni.exerciciosb.model.entities.Produto;
//import org.springframework.data.repository.CrudRepository;
//
//public interface ProdutoRepository
//        extends CrudRepository<Produto, Integer> {
//}
package br.com.giovanni.exerciciosb.model.repositories;

import br.com.giovanni.exerciciosb.model.entities.Produto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface ProdutoRepository
        extends PagingAndSortingRepository<Produto, Integer> {

    public Iterable<Produto> findByNomeContainingIgnoreCase(String parteNome);

    //findByNomeContaining
    //findByNomeiscContaining
    //findByNomeContains
    //
    //findByNomeStartsWith
    //findByNomeEndsWith
    //
    //findByNomeNotContaining

    @Query("SELECT p FROM Produto p WHERE p.nome LIKE %:nome%")
    public Iterable<Produto> searchByNameLike(@Param("nome") String nome);

}
