package io.codeforall.fanstatics;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/form.jsp");
        dispatcher.forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        String mail = req.getParameter("mail");
        String phone = req.getParameter("phone");

        req.setAttribute("name", name);
        req.setAttribute("mail", mail);
        req.setAttribute("phone", phone);

        User user = new User(name, mail, phone);


        RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher("/WEB-INF/card.jsp");
        dispatcher.forward(req, resp);
    }


}




