/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.dsw.exemplosspring;

import java.time.LocalDate;

/**
 *
 * @author ftsuda
 */
public class ExemploService {
    
    public Exemplo obterDados(String nome, LocalDate dataNascimento, int numero) {
        Exemplo dado = new Exemplo();
        dado.setNome(nome + " processado");
        dado.setDataNascimento(dataNascimento);
        dado.setNumero(numero % 6);
        return dado;
    }
    
}
