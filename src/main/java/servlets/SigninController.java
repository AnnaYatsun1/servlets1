package servlets;

import services.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class SigninController extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/view/LoginView.jsp").forward(req,resp);

    }


    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String login= req.getParameter("login");
        String psddword= req.getParameter("password");
        if(UserService.getInstance().isCredentional(login,psddword)){
            HttpSession session= req.getSession();
            synchronized (session){
                session.setAttribute("login",login);
            }
            resp.sendRedirect(String.format("%s/",req.getContextPath()));

        }else {
            req.setAttribute("error", "Credentiona is invalid");
            doGet(req,resp);
        }
    }
}
