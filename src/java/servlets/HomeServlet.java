package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.User;

public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        
         // check status of this session
       boolean login = session.getAttribute("status") != null && session.getAttribute("status").equals("login");
       
       if (!login) {
           getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
           return;
       }
       else {
           getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
           return;
       }
       
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
