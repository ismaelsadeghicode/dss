import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "com.mapsa.dss.servlets.LoginServlet" , urlPatterns = "/login")
public class LoginServlet extends GServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        PrintWriter out = response.getWriter();
        if (USERS.containsKey(username)){
            if (USERS.get(username).equals(password)){
                out.println("WelCome");
            }else{
                out.println("Wrong pass");
            }
        }else{
            out.println("User not found!");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("in doGet");
    }
}
