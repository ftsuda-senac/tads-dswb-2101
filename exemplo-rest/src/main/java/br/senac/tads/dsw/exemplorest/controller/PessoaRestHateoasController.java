/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.dsw.exemplorest.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import br.senac.tads.dsw.exemplorest.dominio.Pessoa;
import br.senac.tads.dsw.exemplorest.dominio.PessoaRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.core.WebHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ftsuda
 */
@RestController
@RequestMapping("/hateoas/pessoas")
public class PessoaRestHateoasController {
    
    @Autowired
    public PessoaRepository pessoaRepository;

    @GetMapping
    public CollectionModel<EntityModel<Pessoa>> listarTodos() {
        List<Pessoa> resultados = pessoaRepository.findAll();
        
        List<EntityModel<Pessoa>> entitiesModels = new ArrayList<>();
        for (Pessoa p : resultados) {
            EntityModel<Pessoa> emp = EntityModel.of(p);
            emp.add(linkTo(methodOn(PessoaRestHateoasController.class).findById(p.getId())).withSelfRel());
            entitiesModels.add(emp);
        }
        CollectionModel<EntityModel<Pessoa>> collectionModel = CollectionModel.of(entitiesModels);
        return collectionModel;
    }
    
    @GetMapping("/{id}")
    public EntityModel<Pessoa> findById(@PathVariable("id") Integer id) {
        return null;
    }
    
}
