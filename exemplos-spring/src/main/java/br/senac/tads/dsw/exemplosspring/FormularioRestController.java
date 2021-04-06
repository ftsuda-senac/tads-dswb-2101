/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.dsw.exemplosspring;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ftsuda
 */
@RestController
@RequestMapping("/formulario-rest")
public class FormularioRestController {
    
    @PostMapping
    public ResponseEntity<?> receberDados(@RequestBody Dados dados) {
        return ResponseEntity.ok(dados);
    }
    
}
