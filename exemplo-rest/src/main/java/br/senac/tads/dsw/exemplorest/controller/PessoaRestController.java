/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.dsw.exemplorest.controller;

import br.senac.tads.dsw.exemplorest.dominio.Interesse;
import br.senac.tads.dsw.exemplorest.dominio.InteresseRepository;
import br.senac.tads.dsw.exemplorest.dominio.Pessoa;
import br.senac.tads.dsw.exemplorest.dominio.PessoaRepository;
import java.net.URI;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 *
 * @author ftsuda
 */
@RestController
@RequestMapping("/rest/pessoas")
public class PessoaRestController {

    private PessoaRepository pessoaRepository;

    private InteresseRepository interesseRepository;
    
    public PessoaRestController(PessoaRepository pessoaRepository, InteresseRepository interesseRepository) {
        this.pessoaRepository = pessoaRepository;
        this.interesseRepository = interesseRepository;
    }

    @GetMapping
    public Page<Pessoa> listar(
            @RequestParam(value = "pagina", defaultValue = "0") int pagina,
            @RequestParam(value = "qtd", defaultValue = "10") int qtd) {
        Page<Pessoa> resultado = pessoaRepository.findAll(PageRequest.of(pagina, qtd));
        return resultado;
    }

    @GetMapping("/todas")
    public List<Pessoa> listarTodas() {
        List<Pessoa> resultado = pessoaRepository.findAll();
        return resultado;
    }

    @GetMapping("/{id}")
    public Pessoa findById(@PathVariable("id") Integer id) {
        Optional<Pessoa> optPessoa = pessoaRepository.findById(id);
        if (!optPessoa.isPresent()) {
            // ERRO: PESSOA NAO ENCONTRADA - LANÇAR ERRO 404 - NOT FOUND
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pessoa com ID " + id + " não encontrada");
        }
        return optPessoa.get();
    }

    @PostMapping
    public ResponseEntity<?> incluirNovo(@RequestBody Pessoa p) {
        // Converte IDs dos interesses em objetos
        Set<Interesse> interesses = new LinkedHashSet<>();
        for (Integer id : p.getInteressesId()) {
            interesseRepository.findById(id).ifPresent(interesse -> interesses.add(interesse));
        }
        p.setInteresses(interesses);
        pessoaRepository.save(p);
        
        // Preparar URI que identifica a pessoa salva
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(p.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
    
}
