public class TeacherService {
    private DAO teacherDAO = new DAO();
    public void saveTeacher(Teachers teacher)
    {
        teacherDAO.save(teacher);

    }

    public void updateTeacher(Teachers teacher)
    {
        teacherDAO.update(teacher);

    }

    public void deleteTeacher(Teachers teacher)
    {
        teacherDAO.delete(teacher);

    }

    public void getAllTeacher(Teachers teacher)
    {
        teacherDAO.getALL();

    }
    public Teachers getTeacher(String first_name)
    {
        return teacherDAO.getTeacher(first_name);
    }


}
