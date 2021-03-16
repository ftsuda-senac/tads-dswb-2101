<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>${dp.nome}</h1>
        <p>Data de Nascimento: ${dp.dataNascimento}</p>
        <p>Telefone: ${dp.telefone}</p>
        <p>E-mail ${dp.email}</p>
        
        <div>
            <h2>Experiências profissionais</h2>
            <ul>
                <c:forEach items="${dp.experienciasProfissionais}" var="exp">
                    <li>
                        <h3>${exp.cargo}</h3>
                        <p>Empresa: ${exp.empresa}</p>
                        <p>Data inicio: ${exp.dataInicio}</p>
                        <p>Data término ${exp.dataTermino}</p>
                    </li>
                </c:forEach>
            </ul>

        </div>
    </body>
</html>
