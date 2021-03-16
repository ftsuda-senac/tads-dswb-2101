package br.senac.tads.dsw.exemplosweb.modelo;

import java.time.LocalDate;
import java.util.List;

public class DadosPessoais {

    private String nome;

    private LocalDate dataNascimento;

    private String telefone;

    private String email;
    
    private List<ExperienciaProfissional> experienciasProfissionais;
    
    private List<FormacaoAcademia> formacaoAcademica;

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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<ExperienciaProfissional> getExperienciasProfissionais() {
        return experienciasProfissionais;
    }

    public void setExperienciasProfissionais(List<ExperienciaProfissional> experienciasProfissionais) {
        this.experienciasProfissionais = experienciasProfissionais;
    }

    public List<FormacaoAcademia> getFormacaoAcademica() {
        return formacaoAcademica;
    }

    public void setFormacaoAcademica(List<FormacaoAcademia> formacaoAcademica) {
        this.formacaoAcademica = formacaoAcademica;
    }

}
