public class Main {
    public static void main(String[] args)
    {
        //DatabaseHelp dataBase = new DatabaseHelp();
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
       //TeacherService.updateTeacher(teacher);
       

    }
}

