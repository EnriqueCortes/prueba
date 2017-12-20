/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.ModelLogin;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class ControllerLogin extends HttpServlet {
String folder = "/VIEWS/";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        ModelLogin bean = new ModelLogin();
        bean.setName(name);
        bean.setPassword(password);
        request.setAttribute("bean", bean);
        boolean status = bean.validate();

        if (status) {
            RequestDispatcher rd = request.getRequestDispatcher(folder + "administrador/login-success.jsp");
            rd.forward(request, response);
            
        } else {
            RequestDispatcher rd = request.getRequestDispatcher(folder + "error.jsp");
            rd.forward(request, response);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doPost(req, resp);
    }
}
