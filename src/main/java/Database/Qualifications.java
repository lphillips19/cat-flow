package Database;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "qualifications")
public class Qualifications {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int QualificationID;

    @Column
    private int ApplicationID;

    @Column
    private String Name;

    @Column
    private String Level;

    @Column
    private String Result;

    @ManyToMany
    @JoinTable(
            name = "applications",
            joinColumns = {@JoinColumn(name = "CandidateID")},
            inverseJoinColumns = {@JoinColumn(name = "JobID")}
    )
    Set<Candidates> candidates = new HashSet<>();

    public Qualifications(int applicationID, String name, String level, String result) {
        ApplicationID = applicationID;
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

    public int getApplicaition() {
        return ApplicationID;
    }

    public void setApplicaition(int applicaitionID) {
        ApplicationID = applicaitionID;
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
