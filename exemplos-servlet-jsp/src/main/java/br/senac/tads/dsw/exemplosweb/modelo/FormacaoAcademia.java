package br.senac.tads.dsw.exemplosweb.modelo;

public class FormacaoAcademia {

    private String curso;

    private String instituicao;

    private Integer anoInicio;

    private Integer anoTermino;

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }

    public Integer getAnoInicio() {
        return anoInicio;
    }

    public void setAnoInicio(Integer anoInicio) {
        this.anoInicio = anoInicio;
    }

    public Integer getAnoTermino() {
        return anoTermino;
    }

    public void setAnoTermino(Integer anoTermino) {
        this.anoTermino = anoTermino;
    }
}
