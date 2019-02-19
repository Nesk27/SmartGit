import javax.persistence.*;


@Entity
@Table(name= "material")
public class Material {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private Teachers teacher;
    @Column(name= "diploma")
    private String diploma;
    @Column(name= "statement")
    private String statement;
    @Column(name= "self_analysis")
    private String self_analysis;
    @Column(name= "refresh_courses")
    private String refresh_courses;
    @Column(name= "other_documents")
    private String other_documents;

    //private List<Avto> avtos;


    public Material () {}

    public Material (String diploma, String statement, String self_analysis, String refresh_courses, String other_documents)
    {
        this.diploma = diploma;
        this.statement = statement;
        this.self_analysis = self_analysis;
        this.other_documents = other_documents;
        this.refresh_courses = refresh_courses;
    }

    public Teachers getTeacher() { return teacher; }

    public void setTeacher(Teachers teacher) { this.teacher = teacher; }


    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setDiploma(String diploma) {
        this.diploma = diploma;
    }

    public String getDiploma() {
        return diploma;
    }


    public void setStatement(String statement) {
        this.statement = statement;
    }

    public String getStatement() {
        return statement;
    }

    public void setSelf_analysis(String self_analysis) {
        this.self_analysis = self_analysis;
    }

    public String getSelf_analysis() {
        return self_analysis;
    }

    public void setRefresh_courses(String refresh_courses) {
        this.refresh_courses = refresh_courses;
    }

    public String getRefresh_courses() {
        return refresh_courses;
    }

    public void setOther_documents(String other_documents) {
        this.other_documents = other_documents;
    }

    public String getOther_documents() {
        return other_documents;
    }

}

