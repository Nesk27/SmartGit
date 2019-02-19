import javax.persistence.*;


@Entity
@Table(name= "users")
public class Users {
    @Id
    @Column(name= "login")
    private String login;
    @Column(name= "passwd")
    private String passwd;

    public void setPasswd(String passwd) {
        this.passwd = passwd;

    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public String getPasswd() {
        return passwd;
    }
}




