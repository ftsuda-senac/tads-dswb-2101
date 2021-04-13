/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.dsw.exemplosspring;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author ftsuda
 */
@Controller
@RequestMapping("/formulario")
public class FormularioController {
    
    @GetMapping
    public ModelAndView mostrarForm() {
        ModelAndView mv = new ModelAndView("formulario");
        mv.addObject("dados", new Dados());
        return mv;
    }
    
    @GetMapping("/preenchido")
    public ModelAndView mostrarFormPreenchido() {
        Dados dados = new Dados();
        dados.setId(123);
        dados.setNome("Chico de Souza");
        dados.setEmail("chico@teste.com.br");
        dados.setTelefone("(11) 98777-1222");
        dados.setDescricao("Biografia do Chico de Souza");
        dados.setNumero(76);
        dados.setPeso(new BigDecimal("98.7"));
        dados.setAltura(new BigDecimal("1.86"));
        dados.setDataNascimento(LocalDate.parse("1997-05-23"));
        dados.setGenero(1);
        dados.setInteresses(Arrays.asList("Esportes", "Viagens"));
        ModelAndView mv = new ModelAndView("formulario");
        mv.addObject("dados", dados);
        return mv;
    }
    
    @PostMapping
    public ModelAndView receberDados(@ModelAttribute Dados dados) {
        ModelAndView mv = new ModelAndView("resultado");
        mv.addObject("dados", dados);
        return mv;
    }
  
    @PostMapping("/post-redirect-get")
    public ModelAndView receberDadosPostRedirectGet(
            @ModelAttribute Dados dados,
            RedirectAttributes redirAttr) {
        ModelAndView mv = new ModelAndView("redirect:/formulario/resultado-post-redirect-get");
        redirAttr.addFlashAttribute("dados", dados);
        return mv;
    }

    @GetMapping("/resultado-post-redirect-get")
    public ModelAndView mostrarResultadosPostRedirectGet() {
        return new ModelAndView("resultado");
    }
   
    @GetMapping("/validacao")
    public ModelAndView mostrarFormValidacao() {
        ModelAndView mv = new ModelAndView("formulario-validacao");
        mv.addObject("dados", new Dados());
        return mv;
    }
    
    @PostMapping("/validacao/post-redirect-get")
    public ModelAndView receberDadosValidacaoPostRedirectGet(
            @Valid @ModelAttribute("dados") Dados dados,
            BindingResult bindingResult,
            RedirectAttributes redirAttr) {
        
        if (bindingResult.hasErrors()) {
            // Erros nos dados preenchidos - Reapresentar formulário
            return new ModelAndView("formulario-validacao");
        }
        
        ModelAndView mv = new ModelAndView("redirect:/formulario/resultado-post-redirect-get");
        redirAttr.addFlashAttribute("dados", dados);
        return mv;
    }

}
