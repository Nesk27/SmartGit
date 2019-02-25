import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Profile extends HttpServlet{
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html; charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        Map<String, Object> pageVariables = new HashMap<>();
        pageVariables.put("username", "Hello!");

        HttpSession session = req.getSession(false);
        if (session != null) {
            resp.getWriter().println(PageGenerator.instance().getPage("profile.html", pageVariables));

            String name = (String)session.getAttribute("login");
            out.println("<center><div class='out'>Мое имя: " + name + "<br>");
            out.println("Session id: " + session.getId());
            Date date = new Date(session.getCreationTime());
            // DateFormat format = new SimpleDateFormat("dd MMM yyy hh:mm:ss zzz");
            out.println("<br>Created at: " + date + "</div></center>");

        } else {
            resp.sendRedirect("login");
        }

        out.close();
    }
}
