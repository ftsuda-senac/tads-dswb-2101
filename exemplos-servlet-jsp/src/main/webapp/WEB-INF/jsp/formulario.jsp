<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Exemplo Servlet+JSP MVC</title>
    </head>
    <body>
        <h1>Exemplo Servlet+JSP MVC</h1>
        <form action="exemplo-mvc" method="post">
            <input type="text" name="texto" />
            <button type="submit">Enviar</button>
        </form>
        <p>User agent: ${ua}</p>
        <p>Host: ${host}</p>
    </body>
</html>
