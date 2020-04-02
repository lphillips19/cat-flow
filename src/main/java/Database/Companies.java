package Database;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "companies")
public class Companies {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int CompanyID;

    @Column
    private String Name;

    @Column
    private String Phone;

    @Column String Email;

    @ManyToMany(mappedBy = "companies")
    private Set<Companies> applications = new HashSet<>();

    public Companies(String name, String phone, String email) {
        Name = name;
        Phone = phone;
        Email = email;
    }

    public Companies(){

    }

    public int getCompanyID() {
        return CompanyID;
    }

    public String getName() {
        return Name;
    }

    public String getPhone() {
        return Phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
