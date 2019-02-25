import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class Main {
    public static void main(String[] args)
    {
        /*//DatabaseHelp dataBase = new DatabaseHelp();
        //System.out.println(dataBase.insertUser("testuser", "testpasswd"));
        //System.out.println(dataBase.checkUser("testuser"));
       TeacherService TeacherService = new TeacherService();

       //Добавление пользователя
       Teachers teacher = new Teachers("Селютин1", "Никита", "Дмитриевич", "В обработке");
       TeacherService.saveTeacher(teacher);

       //Teachers teacher = TeacherService.getTeacher("Никита");
       //System.out.println(teacher.getStatus());

      // Material material = new Material("Диплом", "Заяаление", "Самоанализ", "Курсы о повышении", "Другие документы");
      // material.setTeacher(teacher);
      // teacher.addMaterial(material);
       //TeacherService.updateTeacher(teacher);*/
       Index servlet = new Index();
       NewServlet servlet2 = new NewServlet();
       NewTeacher servlet_add = new NewTeacher();
       Login login = new Login();
       Logout logout = new Logout();
       Profile profile = new Profile();

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(servlet2), "/test");
        context.addServlet(new ServletHolder(servlet_add), "/add");
        context.addServlet(new ServletHolder(servlet), "/index");
        context.addServlet(new ServletHolder(logout), "/logout");
        context.addServlet(new ServletHolder(profile), "/profile");
        context.addServlet(new ServletHolder(login), "/login");

        //context.addServlet(new ServletHolder(login), "/login");

        Server server = new Server(8080);
        server.setHandler(context);

        try {
            server.start();
            server.join();
        } catch (Exception ex) {
            System.out.println("Error close server!");
            ex.printStackTrace();
        }


    }
}

