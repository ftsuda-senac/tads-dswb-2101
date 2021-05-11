/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.dsw.exemplosspring.produto;

import java.util.List;
import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ftsuda
 */
@Repository
public class ProdutoRepositoryJpaImpl implements ProdutoRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Produto> findAll(int offset, int quantidade) {
//        TypedQuery<Produto> jpqlQuery
//                = em.createQuery("SELECT p FROM Produto p", Produto.class);
        TypedQuery<Produto> jpqlQuery = em.createNamedQuery("Produto.findAll", Produto.class);
        jpqlQuery.setFirstResult(offset);
        jpqlQuery.setMaxResults(quantidade);
        return jpqlQuery.getResultList();
    }

    @Override
    public List<Produto> findByCategoria(List<Integer> idsCat, int offset, int quantidade) {
        TypedQuery<Produto> jpqlQuery = em.createNamedQuery("Produto.findAllByCategoriasId", Produto.class);
        jpqlQuery.setParameter("idsCat", idsCat);
        jpqlQuery.setFirstResult(offset);
        jpqlQuery.setMaxResults(quantidade);
        return jpqlQuery.getResultList();
    }

    @Override // SÓ FUNCIONA COM open-in-view=true no application.properties
    public Produto findById(Long id) {
        TypedQuery<Produto> jpqlQuery = em.createQuery("SELECT p FROM Produto p WHERE p.id = :idProd", Produto.class);
        jpqlQuery.setParameter("idProd", id);
        Produto p = jpqlQuery.getSingleResult();
        return p;
    }

    public Produto findByIdComFetch(Long id) {
        TypedQuery<Produto> jpqlQuery = em.createNamedQuery("Produto.findByIdComFetch", Produto.class);
        jpqlQuery.setParameter("idProd", id);
        return jpqlQuery.getSingleResult();
    }
    
    public Produto findByIdComNamedEntityGraph(Long id) { // ComNamedEntityGraph
        EntityGraph<?> namedEntityGraph = em.getEntityGraph("graph.ProdutoCategoriasImagens");
        TypedQuery<Produto> jpqlQuery = em.createQuery("SELECT p FROM Produto p WHERE p.id = :idProd", Produto.class);
        jpqlQuery.setParameter("idProd", id);
        jpqlQuery.setHint("javax.persistence.loadgraph", namedEntityGraph);
        return jpqlQuery.getSingleResult();
    }

    @Transactional
    @Override
    public Produto save(Produto p) {
        if (p.getId() == null) {
            // Inclui novo produdo
            em.persist(p);
        } else {
            // Atualiza produto existente
            p = em.merge(p);
        }
        return p;
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        // Fazer consulta para manter o Produto no EntityManager (ATTACHED)
        Produto p = em.find(Produto.class, id);
        em.remove(p);
    }

}
