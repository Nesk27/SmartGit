import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import java.util.List;


public class DatabaseHelp {
    private static SessionFactory dbSession;

    public static SessionFactory getSessionFactory()
    {
        if (dbSession == null)
        {
            Configuration conf = new Configuration().configure("/hibernate.cfg.xml");
            conf.addAnnotatedClass(Users.class);
            conf.addAnnotatedClass(Teachers.class);
            conf.addAnnotatedClass(Material.class);

            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(conf.getProperties());
            dbSession = conf.buildSessionFactory(builder.build());
        }
        return dbSession;
    }

    public String insertUser(String login, String passwd)
    {

        if(dbSession == null) {
            dbSession = getSessionFactory();
        }
        Session  session = dbSession.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Users user = new Users();
            user.setLogin(login);
            user.setPasswd(passwd);
            session.save(user);
            transaction.commit();

        } catch (HibernateException ex) {
            if (transaction != null)
                transaction.rollback();
            ex.printStackTrace();
            return "Ошибка транзакции";

        } finally {
            session.close();
        }
        return "Данные добавлены";

    }

    public String checkUser(String login)
    {

        if (dbSession == null)
        {
            dbSession = getSessionFactory();
        }
        Session session = dbSession.openSession();
        try {
            Query query = session.createQuery("from Users where login = :log");
            query.setParameter("log", login);
            List users = query.list();
            if (users.size() == 0) {
                return "-1";
            }

            Users user = (Users)users.iterator().next();
            return user.getPasswd();


        } catch (HibernateException ex)
        {
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return "not connection";
    }
}
