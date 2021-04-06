/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.dsw.exemplosspring;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class Exemplo {
    
    private String nome;
    
    private LocalDate dataNascimento;
    
    private int numero;
    
    private List<String> telefones;
    
    public Exemplo() {
        
    }
    
    public Exemplo(String nome, LocalDate dataNascimento, int numero) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public List<String> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<String> telefones) {
        this.telefones = telefones;
    }
    
    public boolean isMenorIdade() {
        long idade = ChronoUnit.YEARS.between(dataNascimento, LocalDate.now());
        return idade < 18;
    }
    
}
