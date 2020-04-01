package Database;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity(name = "qualifications")
public class Qualifications {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int QualificationID;

    @Column
    @ManyToOne
    private Collection<Applications> Applicaition = new ArrayList<Applications>();

    @Column
    private String Name;

    @Column
    private String Level;

    @Column
    private String Result;

    public Qualifications(Collection<Applications> applicaition, String name, String level, String result) {
        Applicaition = applicaition;
        Name = name;
        Level = level;
        Result = result;
    }

    public Qualifications(){

    }

    public int getQualificationID() {
        return QualificationID;
    }

    public void setQualificationID(int qualificationID) {
        QualificationID = qualificationID;
    }

    public Collection<Applications> getApplicaition() {
        return Applicaition;
    }

    public void setApplicaition(Collection<Applications> applicaition) {
        Applicaition = applicaition;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getLevel() {
        return Level;
    }

    public void setLevel(String level) {
        Level = level;
    }

    public String getResult() {
        return Result;
    }

    public void setResult(String result) {
        Result = result;
    }
}
