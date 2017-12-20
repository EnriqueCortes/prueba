<%@page session="true" %>
<p>You are successfully logged in!</p>
<%
    HttpSession sesion = request.getSession();
    out.print("Welcome Administrador, " + sesion.getAttribute("usr"));
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

        <sql:setDataSource var = "snapshot" driver = "com.mysql.jdbc.Driver"
                           url = "jdbc:mysql://localhost:3306/prueba"
                           user = "root"  password = "  "/>
        <sql:query dataSource = "${snapshot}" sql = "select * from usuario" var = "result" />
        <table>
            <thead>
                <tr><th>nombre</th><th>nivel</th>
                    <th>pass</th><th>Acciones</th></tr>
            </thead>
            <tbody>
                <c:forEach var="rs" begin="0" items="${result.rows}">
                    <tr>
                        <td>${rs.user}</td>
                        <td>${rs.nivel}</td>
                        <td>${rs.pass}</td>
                        <td><a href='/detalle.jsp?id=${rs.id}'>
                                <input type="submit" value="Detalle"/></a>
                            <a href='/eliminar.jsp?id=${rs.id}'>
                                <input type="submit" value="Eliminar"/></a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
            <tfoot>
                <tr><td><a href='/agregarProfesor.jsp'>
                            <input type="submit" name="action" value="Agregar"/></a>
                    </td><td></td><td></td><td></td></tr>
            </tfoot>
        </table>