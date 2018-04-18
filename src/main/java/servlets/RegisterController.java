package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class RegisterController extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.print("hellow");

        int a = 10000;
        int b = 10000000;
        int random_number1 = a + (int) (Math.random() * b);
        int random_number2 = a + (int) (Math.random() * b);
        String publicKey = String.valueOf(random_number1);
        String privateKey = String.valueOf(random_number2);
        req.getSession().setAttribute("publicKey", publicKey);
        ;
        try {
            Class.forName("org.postgresql.Driver");
            //   Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Test", "postgres", "password");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Test", "postgres", "password");
            Statement st = connection.createStatement();
            int i = st.executeUpdate("insert INTO key_for_user VALUES ('" + publicKey + "', '" + privateKey + "')");
            // statement.set
            if (i > 0) {
                resp.sendRedirect("LoginSuccess.jsp");


            } else {
                out.println("data is inserted");
            }
        } catch (Exception e) {
            out.print(e);

        }
    }
}
