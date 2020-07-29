import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;



@WebServlet(name = "com.mapsa.dss.servlets.RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends GServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String repeatPassword = request.getParameter("repeatPassword");

        PrintWriter out = response.getWriter();

        if (USERS.containsKey(username)){
            out.println("user exist.");
        }else{
            if (password.equals(repeatPassword)){
                USERS.put(username,password);
                out.println("<h1>Done</h2>");
            }else{
                out.println("Password not match.");
            }
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("get-register");
    }
}
