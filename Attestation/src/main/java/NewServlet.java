import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;


public class NewServlet extends HttpServlet{
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        resp.setContentType("text/html; charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        Map<String, Object> pageVariables = new HashMap<>();
        pageVariables.put("username", "Hello!");

        HttpSession session = req.getSession(false);
        if (session != null) {
            resp.getWriter().println(PageGenerator.instance().getPage("page.html", pageVariables));
            String username = req.getParameter("first_name");
            PrintWriter out = resp.getWriter();
            TeacherService TeacherService = new TeacherService();

            if (username != null) {
                out.print("<center><div class='out'>");
                Teachers teacher = TeacherService.getTeacher(username);
                if (teacher != null) {
                    out.println("Фамилия: " + teacher.getLast_name() + "; Имя: " + teacher.getFirst_name() + "; Отчество: " + teacher.getSurname() + ";");
                    out.println("<br>Статус заявления: " + teacher.getStatus());
                } else {
                    out.print("<div style='color:red;'>Нет такого преподавателя!</div>");
                }
                out.print("</div></center>");
            }
        } else
        {
            resp.sendRedirect("login");
        }
        //Отправляем в ответ
        //out.print(teacher.getStatus());
        /*Map<String, Object> pageVariables = new HashMap<>();
        pageVariables.put("username", "Hello!");

        resp.getWriter().println(PageGenerator.instance().getPage("page.html", pageVariables));

        resp.setContentType("text/html; charset=UTF-8");
        resp.setStatus(HttpServletResponse.SC_OK);
        PrintWriter out = resp.getWriter();
        out.print("We are in GET!");*/
    }

    /*public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Map<String, Object> pageVariables = new HashMap<>();
        pageVariables.put("message", "Hello!");



        resp.getWriter().println(PageGenerator.instance().getPage("page.html", pageVariables));

        resp.setContentType("text/html; charset=UTF-8");
        resp.setStatus(HttpServletResponse.SC_OK);
        PrintWriter out = resp.getWriter();
        out.print("We are in POST!");

    }*/
}