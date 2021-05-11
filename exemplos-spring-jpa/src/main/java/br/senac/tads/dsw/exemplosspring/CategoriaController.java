/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */
package br.senac.tads.dsw.exemplosspring;

import br.senac.tads.dsw.exemplosspring.produto.Categoria;
import br.senac.tads.dsw.exemplosspring.produto.CategoriaRepositorySpringData;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author fernando.tsuda
 */
@Controller
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaRepositorySpringData repository;

    @GetMapping
    public ModelAndView listar() {
        List<Categoria> resultados = repository.findAll();
        return new ModelAndView("categoria/lista").addObject("categorias", resultados);
    }

    @GetMapping("/novo")
    public ModelAndView adicionarNovo() {
        return new ModelAndView("categoria/form").addObject("categoria", new Categoria());
    }

    @GetMapping("/{id}/editar")
    public ModelAndView editar(@PathVariable("id") int id) {
        Optional<Categoria> optCat = repository.findById(id);
        if (optCat.isEmpty()) {
            // TODO: Mostrar erro adequadamente
            return new ModelAndView("redirect:/categoria");
        }
        return new ModelAndView("categoria/form").addObject("categoria", optCat.get());
    }

    @PostMapping("/salvar")
    public ModelAndView salvar(@ModelAttribute @Valid Categoria cat, BindingResult bindingResult,
            RedirectAttributes redirAttr) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("categoria/form");
        }
        repository.save(cat);
        redirAttr.addFlashAttribute("msgSucesso",
                "Categoria " + cat.getNome() + " salva com sucesso");
        return new ModelAndView("redirect:/categoria");
    }

}
