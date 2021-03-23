/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.dsw.exemplosspring;

import java.time.LocalDate;
import java.time.LocalDateTime;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExemploController {
    
    @GetMapping("/ex1")
    public String exemplo1() {
        return "exemplo1";
    }

    @GetMapping("/ex2")
    public String exemplo2(Model model) {
        model.addAttribute("nome", "Fulano da Silva");
        model.addAttribute("dataNascimento", LocalDate.parse("2000-05-11"));
        model.addAttribute("numero", 63);
        model.addAttribute("dataHoraAtual", LocalDateTime.now());
        return "exemplo2";
    }

    @GetMapping("/ex2b")
    public ModelAndView exemplo2b() {
        ModelAndView mv = new ModelAndView("exemplo2");
        mv.addObject("nome", "Beltrana das Cruzes");
        mv.addObject("dataNascimento", LocalDate.parse("1999-10-25"));
        mv.addObject("numero", 36);
        mv.addObject("dataHoraAtual", LocalDateTime.now());
        return mv;
    }
    
    @GetMapping("/ex3")
    public String exemplo3(Model model) {
        Exemplo dado = new Exemplo();
        dado.setNome("Ciclano de Souza");
        dado.setDataNascimento(LocalDate.parse("1998-04-23"));
        dado.setNumero(21);
        model.addAttribute("dados", dado);
        model.addAttribute("dataHoraAtual", LocalDateTime.now());
        return "exemplo3";
    }
}
