/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.dsw.exemplosspring;

import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author ftsuda
 */
public class MainPadrao {
    
    private ExemploService service = new ExemploService();
    
    public void executar() {
        
        Scanner entrada = new Scanner(System.in);
        while(true) {
            System.out.println("Digite o nome: ");
            String nome = entrada.nextLine();
            System.out.println("Digite a data nascimento no formato yyyy-MM-dd:");
            String dataStr = entrada.nextLine();
            System.out.println("Digite um número de 1 a 99");
            String numeroStr = entrada.nextLine();

            Exemplo dado = service.obterDados(nome, LocalDate.parse(dataStr), Integer.parseInt(numeroStr));

            System.out.println("Dados digitados:\r\nNome: " + dado.getNome() + "\r\nData Nascimento: " + dado.getDataNascimento() + "\r\nNúmero: " + dado.getNumero());
        }

    }
    
    public static void main(String[] args) {
        MainPadrao main = new MainPadrao();
        main.executar();
    }
    
}
