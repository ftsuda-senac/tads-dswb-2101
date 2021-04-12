/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.dsw.exemplosspring;

import org.springframework.stereotype.Controller;
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
    
}
