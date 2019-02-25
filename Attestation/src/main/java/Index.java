import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Index  extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {


        resp.setContentType("text/html; charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession(false);
        if (session != null) {
            Map<String, Object> pageVariables = new HashMap<>();
            pageVariables.put("username", "Hello!");

            resp.getWriter().println(PageGenerator.instance().getPage("index.html", pageVariables));
        } else {
            resp.sendRedirect("login");
        }


    }
}
