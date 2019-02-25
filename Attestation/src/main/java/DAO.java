import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class DAO {
    public void save(Teachers teacher) {
        Session session = DatabaseHelp.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
        session.save(teacher);
        trans.commit();
        session.close();
    }

    public void update(Teachers teacher)
    {
        Session session = DatabaseHelp.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
        session.update(teacher);
        trans.commit();
        session.close();
    }

    public void delete(Teachers teacher)
    {
        Session session = DatabaseHelp.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
        session.delete(teacher);
        trans.commit();
        session.close();
    }

    public List getALL()
    {
        return DatabaseHelp.getSessionFactory().openSession().createQuery("from Teachers").list();
    }

   /* public List<Owners> getAll() {
        List<Owners> Owners = (List<Owners>)  DatabaseHelp.getSessionFactory().openSession().createQuery("From Owners").list();
        return Owners;
    }*/

    /*public Owners getOwner(String name) {
        Query query = DatabaseHelp.getSessionFactory().openSession().createQuery("from Owners where name = :name");
        query.setParameter("name", name);
        List list = query.list();
        Owners owner = (Owners)list.iterator().next();
        //return "Владелец: " + owner.getName() + " , Возраст: " + owner.getAge();
        return owner;
    }*/

    public Teachers getTeacher(String first_name){
        Session session = DatabaseHelp.getSessionFactory().openSession();
        Query query = session.createQuery("from Teachers where first_name = :first_name");
        query.setParameter("first_name", first_name);
        List list = query.list();
        if (list.size() == 0) {
            return null;
        }

        Teachers teacher = (Teachers)list.iterator().next();
        session.close();
        return teacher;
    }





}
