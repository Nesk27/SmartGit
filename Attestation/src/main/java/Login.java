import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Login extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //Получение json из потока

        resp.setContentType("text/html; charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        Map<String, Object> pageVariables = new HashMap<>();
        pageVariables.put("message", "Hello!");

        resp.getWriter().println(PageGenerator.instance().getPage("login.html", pageVariables));
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html/utf-8");
        PrintWriter out = resp.getWriter();

        Map<String, Object> pageVariables = new HashMap<>();
        pageVariables.put("message", "Hello!");

        String login = req.getParameter("login");
        String pass = req.getParameter("pass");
        DatabaseHelp dataBase = new DatabaseHelp();
        String check = dataBase.checkUser(login);
        if (!Objects.equals(check, "-1") && (check.equals(pass)))
        {
            HttpSession session = req.getSession();
            session.setAttribute("login", login);
            resp.sendRedirect("index");
        } else {
            out.println("Wrong password, try again!");
            resp.sendRedirect("login");
        }
        out.close();
    }


    private Integer sessionCunter(HttpSession session) {
        Integer counter = (Integer)session.getAttribute("counter");

        if (counter == null) {
            session.setAttribute("counter", 1);
            return 1;
        } else {
            ++counter;
            session.setAttribute("counter", counter);
            return counter;
        }
    }
}