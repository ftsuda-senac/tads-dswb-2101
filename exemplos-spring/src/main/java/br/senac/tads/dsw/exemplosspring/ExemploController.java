/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.dsw.exemplosspring;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/ex3b")
    public ModelAndView exemplo3b() {
        Exemplo dado = new Exemplo();
        dado.setNome("José da Silva");
        dado.setDataNascimento(LocalDate.parse("1999-01-31"));
        dado.setNumero(38);
        ModelAndView mv = new ModelAndView("exemplo3");
        mv.addObject("dados", dado);
        mv.addObject("dataHoraAtual", LocalDateTime.now());
        return mv;
    }
  
    @GetMapping("/ex4")
    public ModelAndView exemplo4() {
        List<Exemplo> lista = new ArrayList<>();
        lista.add(new Exemplo("Fulano da Silva", LocalDate.parse("2000-10-25"), 47));
        lista.add(new Exemplo("Beltrano das Cruzes", LocalDate.parse("2003-03-15"), 20));
        
        Exemplo p3 = new Exemplo("Ciclano de Souza", LocalDate.parse("2004-06-28"), 78);
        List<String> telefones = Arrays.asList("(11) 99999-1234", "(11) 99999-9988", "(11) 99999-9987");
        p3.setTelefones(telefones);
        lista.add(p3);
        
        ModelAndView mv = new ModelAndView("exemplo4");
        mv.addObject("lista", lista);
        return mv;
    }

    @GetMapping("/ex5")
    public ModelAndView exemplo5(
            @RequestParam("nome") String nome,
            @RequestParam(value = "dtnasc", required=false) String dataNascStr,
            @RequestParam(value = "numero", defaultValue="0") int numero) {
        
        Exemplo dadosInformados = new Exemplo();
        dadosInformados.setNome(nome);
        if (dataNascStr != null) {
            dadosInformados.setDataNascimento(LocalDate.parse(dataNascStr));
        }
        dadosInformados.setNumero(numero);
        
        ModelAndView mv = new ModelAndView("exemplo5");
        mv.addObject("dados", dadosInformados);
        return mv;
    }
    
    @GetMapping("/ex6/{apelido}")
    public ModelAndView exemplo6(
            @PathVariable("apelido") String apelido) {
        
        ModelAndView mv = new ModelAndView("exemplo6");
        if ("fulano".equals(apelido)) {
            mv.addObject("dados", new Exemplo("Fulano da Silva", LocalDate.parse("2000-01-20"), 20));
        } else if ("ciclano".equals(apelido)) {
            mv.addObject("dados", new Exemplo("Ciclano de Souza", LocalDate.parse("1999-05-20"), 56));
        }
        return mv;
    }
    
    @GetMapping("/ex7")
    public ModelAndView exemplo7(
            @RequestHeader("user-agent") String userAgent) {
        ModelAndView mv =new ModelAndView("exemplo7");
        mv.addObject("ua", userAgent);
        return mv;
    }
    
    @GetMapping("/ex8")
    public ModelAndView exemplo8(
            @RequestHeader Map<String, String> headersHttp
    ){
        ModelAndView mv = new ModelAndView("exemplo8");
        mv.addObject("headers", headersHttp);
        return mv;
    }
}
