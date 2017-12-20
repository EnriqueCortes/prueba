<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<%@page session="true" %>
<!DOCTYPE html>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <form action="Login" method="post">
            Name:<input type="text" name="name"><br>
            Password:<input type="password" name="password"><br>
            <input type="submit" value="login">
        </form>
        <%
            HttpSession sesion = request.getSession();
            int nivel=0;
            if (request.getAttribute("nivel") != null) {
                nivel = (Integer) request.getAttribute("nivel");
                if (nivel == 1) {
                    out.print("nivel22 " + nivel);
                    sesion.setAttribute("nivel", request.getAttribute("nivel"));
                    sesion.setAttribute("usr", request.getAttribute("nombre"));
                    String baseUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
                    String redirectURL = baseUrl + "Admin";
                    response.sendRedirect(redirectURL);
                }
                else if (nivel == 2) {
                    sesion.setAttribute("nivel", request.getAttribute("nivel"));
                    sesion.setAttribute("usr", request.getAttribute("nombre"));
                    String baseUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
                    String redirectURL = baseUrl + "Admin";
                    response.sendRedirect(redirectURL);
                }
            }
        %>

    </body>
</html>
