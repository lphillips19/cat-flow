package Database;
import javax.persistence.*;

@Entity(name= "candidates")
public class Candidates {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int CandidateID;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String Gender;

    @Column
    private String Ethnicity;

    @Column
    private String Email;

    @Column
    private String Phone;

    public Candidates(String firstName, String lastName, String gender, String ethnicity, String email, String phone){
        this.firstName = firstName;
        this.lastName = lastName;
        this.Gender = gender;
        this.Ethnicity = ethnicity;
        this.Email = email;
        this.Phone = phone;
    }

    public Candidates(){

    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public void setEthnicity(String ethnicity) {
        Ethnicity = ethnicity;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public int getCandidateID() {
        return CandidateID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGender() {
        return Gender;
    }

    public String getEthnicity() {
        return Ethnicity;
    }

    public String getEmail() {
        return Email;
    }

    public String getPhone() {
        return Phone;
    }
}
