/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.*;
import java.util.Optional;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import models.User;
import services.AccountService;

/**
 *
 * @author @bellaegenti1
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        Object status = session.getAttribute("status");
        
       // String logout = request.getParameter("logout");
        if  (request.getParameter("logout")!= null){
            request.getSession().invalidate();

            request.setAttribute("logoutMessage", "You have logged out successfuly");

            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);

        } 
        
          else if (status != null && status.equals("login")){
            getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
            return;
            
            /**else {

            if (session.getAttribute("user") != null) {
                User user = (User) session.getAttribute("user");
                String username = user.getUsername();
                request.setAttribute("username", username);
                response.sendRedirect("home");
                **/
            } else {
              getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
                //response.sendRedirect("login");
            }
        }

    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        boolean usernamePasswordNotEmpty = isUsernamePasswordNotEmpty(username, password);

        if (usernamePasswordNotEmpty) {
            AccountService service = new AccountService();
            User user = service.login(username, password);

            if (user == null) {
                request.setAttribute("errorMessage", "Username or password is not right");
                getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            } else {
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                response.sendRedirect("home");
            }
        }
    }

    private boolean isUsernamePasswordNotEmpty(String username, String password) {
        boolean valid = false;
        if (username.equals("") || username == null || password.equals("") || password == null) {
            valid = false;
        } else {
            valid = true;
        }
        return valid;
    }

}
