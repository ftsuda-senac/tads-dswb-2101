/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */
package br.senac.tads.dsw.exemplospringsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author fernando.tsuda
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @GetMapping
    public String mostrarFormLogin() {
        return "login";
    }

}
