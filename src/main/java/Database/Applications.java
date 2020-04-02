package Database;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "applications")
@Table
public class Applications {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, nullable = false)
    private int ApplicationID;

    @Column
    private int CandidateID;

    @Column
    private int JobID;

    @ManyToMany()
    @JoinTable(
            name = "jobs",
            joinColumns = {@JoinColumn(name = "ApplicationID")},
            inverseJoinColumns = {@JoinColumn(name = "CompanyID")}
    )
    Set<Companies> applications = new HashSet<>();

    public Applications(int JobID, int candidateID){
        this.ApplicationID = JobID;
        this.CandidateID = candidateID;
    }

    public Applications(){

    }

    public int getApplicationID() {
        return ApplicationID;
    }

    public int getCandidateID() {
        return CandidateID;
    }

    public int getJobID() {
        return JobID;
    }

    public void setJob(int jobID) {
        this.JobID = jobID;
    }

    public void setCandidate(int candidateID) {
        this.CandidateID = candidateID;
    }
}
