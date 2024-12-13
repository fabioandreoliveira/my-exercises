package io.codeforall.fanstatics;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = new User();

        user.setName("Catarina Campino");
        user.setEmail("catarina.campino@academiadecodigo.org");
        user.setPhone(999999);

        getServletContext().setAttribute("user", user);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/customer.jsp");
        dispatcher.forward(req, resp);
    }
}
