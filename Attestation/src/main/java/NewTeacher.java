import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;


public class NewTeacher extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //Получение json из потока

        resp.setContentType("text/html; charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        Map<String, Object> pageVariables = new HashMap<>();
        pageVariables.put("username", "Hello!");


        HttpSession session = req.getSession(false);
        if (session != null) {
            resp.getWriter().println(PageGenerator.instance().getPage("add.html", pageVariables));
            String first_name = req.getParameter("first_name");
            String last_name = req.getParameter("last_name");
            String surname = req.getParameter("surname");
            //String password = req.getParameter("password");

            //Готовим ответ на корректность пароля и логина
            PrintWriter out = resp.getWriter();

            TeacherService TeacherService = new TeacherService();
            if ((last_name != null && first_name != null && surname != null) && (last_name.trim().length() != 0 && first_name.trim().length() != 0 && surname.trim().length() != 0)) {
                Teachers teacher = new Teachers(last_name, first_name, surname, "В обработке");
                TeacherService.saveTeacher(teacher);
                out.print("<br><center><div class='out'>Данные успешно добавлены:<br>");
                out.print(teacher.getLast_name() + " " + teacher.getFirst_name() + " " + teacher.getSurname() + "; Статус заявления: " + teacher.getStatus() + "</div><br>");
            }
        } else {
            resp.sendRedirect("login");
        }

    }
}
