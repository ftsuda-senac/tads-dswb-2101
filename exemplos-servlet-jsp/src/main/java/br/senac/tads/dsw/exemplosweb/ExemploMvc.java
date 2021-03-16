/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.dsw.exemplosweb;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
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
@WebServlet(name = "ExemploMvc", urlPatterns = {"/exemplo-mvc"})
public class ExemploMvc extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String ua = request.getHeader("user-agent");
        String host = request.getHeader("host");
        
        request.setAttribute("ua", ua);
        request.setAttribute("host", host);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/formulario.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String valorPrenchido = request.getParameter("texto");
        request.setAttribute("vp", valorPrenchido);
        request.setAttribute("dataHora", LocalDateTime.now());
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/resultado.jsp");
        dispatcher.forward(request, response);
    }

}
