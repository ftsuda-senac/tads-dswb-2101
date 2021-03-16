/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.dsw.exemplosweb;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ftsuda
 */
@WebServlet(name = "ExemploServlet", urlPatterns = {"/xpto"})
public class ExemploServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ExemploServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ExemploServlet at " + request.getContextPath() + "</h1>");
            out.println("<h2>Texto gerado no Servlet - método doGet() </h2>");
            out.println("<form action=\"xpto\" method=\"post\">");
            out.println("<input type=\"text\" name=\"texto\" />");
            out.println("<button type=\"submit\">Enviar</button>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String valorPreenchido = request.getParameter("texto");
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ExemploServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Valor preenchido: " + valorPreenchido + "</h1>");
            out.println("<a href=\"xpto\">Voltar</a>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        }
        
    }

}
