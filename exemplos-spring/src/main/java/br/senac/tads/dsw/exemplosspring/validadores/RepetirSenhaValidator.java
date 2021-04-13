/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.dsw.exemplosspring.validadores;

import br.senac.tads.dsw.exemplosspring.Dados;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author ftsuda
 */
public class RepetirSenhaValidator implements ConstraintValidator<RepetirSenha, Dados> {

    @Override
    public void initialize(RepetirSenha constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isValid(Dados dados, ConstraintValidatorContext cvc) {
        String senha = dados.getSenha();
        String repetirSenha = dados.getRepetirSenha();
        return senha.equals(repetirSenha);
    }
    
}
