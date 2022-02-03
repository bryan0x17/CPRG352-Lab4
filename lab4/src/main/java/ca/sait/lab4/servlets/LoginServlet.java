
package ca.sait.lab4.servlets;

import ca.sait.lab4.model.User;
import ca.sait.lab4.services.AccountService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginServlet extends HttpServlet {

    
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        // Get the query string and check it for logout
        String query = request.getQueryString() != null ? request.getQueryString() : "";
        String message = "";
        if (query.contains("logout")) {
            message = "You have successfully logged out";
            session.invalidate();
            // TODO: Invalidate the session
        } else if (session.getAttribute("username") != null) {
            response.sendRedirect("home");
            return;
        }
        request.setAttribute("message", message);
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String message = "";
        
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            message = "Username or password is missing";
            request.setAttribute("message", message);
        } else {
            AccountService account = new AccountService();
            User user = account.login(username, password);
            
            if (user != null) {
                request.getSession().setAttribute("username", username);
                response.sendRedirect("home");
                return;
            } else {
                request.setAttribute("username", username);
                message = "Incorrect username or password";
                request.setAttribute("message", message);
            }
        }
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }
}
