/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.dsw.exemplosspring.produto;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/*
Criação dos métodos de busca:
https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods
https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.query-methods.query-property-expressions
*/
@Repository
public interface ProdutoRepositorySpringData 
        extends JpaRepository<Produto, Long> {
    
    Page<Produto> findByCategorias_IdIn(List<Integer> idsCat, Pageable page);
    
    List<Produto> findByNome(String nome);
    
    List<Produto> findByNomeAndDescricaoContaining(String nome, String descricao);
    
    List<Produto> findByNomeIgnoreCaseContainingAndDescricaoIgnoreCaseContaining(String nome, String descricao);
    
    // Uso do JPQL com Spring Data JPA
    @Query("SELECT p FROM Produto p WHERE upper(p.nome) LIKE upper('%'||:parametro||'%') OR upper(p.descricao) LIKE upper('%'||:parametro||'%')")
    List<Produto> findByTextoComJpql(@Param("parametro") String texto);
    
    // Uso do SQL nativo com Spring Data JPA
    @Query(nativeQuery = true, value = "SELECT * FROM PRODUTO WHERE upper(nome) LIKE upper('%'||:parametro||'%') OR upper(descricao) LIKE upper('%'||:parametro||'%')")
    List<Produto> findByTextoComSqlNativo(@Param("parametro") String texto);
    
}
