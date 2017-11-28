import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet(urlPatterns = "/login")
public class LoginServelet extends HttpServlet {
    ConnectDB connectDB;
    @Override
    public void init() throws ServletException {
        connectDB = new ConnectDB();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("login");
        String password = req.getParameter("password");

        try{
            Statement statement = connectDB.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users where login = '" + name + "' and password" +
                    " = '" + password + "'");
            resp.setContentType("text/html");
            PrintWriter writer = resp.getWriter();

            if(resultSet.next() == true) {
                writer.write(String.valueOf(resultSet.getInt(1)));
            }
            else writer.write("0");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
