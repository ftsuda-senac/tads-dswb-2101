package br.senac.tads.dsw.exemplosweb;

import br.senac.tads.dsw.exemplosweb.modelo.DadosPessoais;
import br.senac.tads.dsw.exemplosweb.modelo.ExperienciaProfissional;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ftsuda
 */
@WebServlet(name = "DadosPessoaisServlet", urlPatterns = {"/dados-pessoais"})
public class DadosPessoaisServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        DadosPessoais dp = new DadosPessoais();
        dp.setNome("Fulano da Silva");
        dp.setDataNascimento(LocalDate.of(2000, 6, 20));
        dp.setTelefone("(11) 99999-1234");
        dp.setEmail("fulano@teste.com.br");
        
        List<ExperienciaProfissional> experiencias = new ArrayList<>();
        
        ExperienciaProfissional ep1 = new ExperienciaProfissional();
        ep1.setCargo("Cargo A");
        ep1.setEmpresa("Empresa ABC");
        ep1.setDataInicio(LocalDate.of(2015, 1, 1));
        ep1.setDataTermino(LocalDate.of(2015, 12, 1));
        experiencias.add(ep1);
        
        ExperienciaProfissional ep2 = new ExperienciaProfissional();
        ep2.setCargo("Cargo B");
        ep2.setEmpresa("Empresa XPTO");
        ep2.setDataInicio(LocalDate.of(2015, 1, 1));
        ep2.setDataTermino(LocalDate.of(2015, 12, 1));
        experiencias.add(ep2);
        
        dp.setExperienciasProfissionais(experiencias);
        
        request.setAttribute("dp", dp);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/dados-pessoais.jsp");
        dispatcher.forward(request, response);
        
    }

}
